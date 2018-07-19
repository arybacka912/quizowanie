package com.pl.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email")
    @Email(message = "Please provide a valid Email")
    @NotEmpty(message = "Please provide an email")
    private String email;

    @Column(name = "username")
    @NotEmpty(message = "Please provide your username")
    private String username;

    @Column(name = "password", unique = true)
    @Length(min = 5, message = "Your password must have at least 5 char")
    @NotEmpty(message = "Please provide your password")
    @JsonIgnore
    private String password;

    @Column(name = "enabled")
    @JsonIgnore
    private boolean enabled;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



    public User(String email, String username, String password, boolean enabled, Date createdDate) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.createdDate = createdDate;
    }
}