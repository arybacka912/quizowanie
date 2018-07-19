package com.pl.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@OneToOne
	@JsonIgnore
	private UserQuiz userQuiz;

	@Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
	@NotNull(message = "Please provide a name")
	private String name;

	@Size(max = 500, message = "The description can't be longer than 500 char")
	@NotNull(message = "Please, provide a description")
	private String description;

	@OneToMany
	@JsonIgnore
	private List<Question> questions;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date createdDate;

	private Boolean isPublished = false;

	public Date getCreatedDate() {
		return createdDate;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> exercises) {
		this.questions = exercises;
	}

	public UserQuiz getCreatedBy() {
		return userQuiz;
	}

	public void setCreatedBy(UserQuiz userQuiz) {
		this.userQuiz = userQuiz;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Boolean getIsPublished() {
		return isPublished;
	}

	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

	public Quiz(UserQuiz userQuiz, String name, String description, List<Question> questions, Date createdDate, Boolean isPublished) {
		this.userQuiz = userQuiz;
		this.name = name;
		this.description = description;
		this.questions = questions;
		this.createdDate = createdDate;
		this.isPublished = isPublished;
	}

	public Quiz() {
	}
}
