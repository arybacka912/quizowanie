package com.pl.domain;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Size(min = 1, max = 50, message = "The answer should be less than 50 char")
    @NotNull(message = "No answer text provided")
    private String text;

    @Column (name = "true/false")
    private boolean isCorrectAnswer;

    @Column(name = "a_order")
    private Integer order;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Date createdDate;



    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        isCorrectAnswer = correctAnswer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Answer [text= " + text + ",isCorrectAnswer= " + isCorrectAnswer + ", order= " + order + ", createdDate= " + createdDate
                + "]";
    }

    public Answer(String text, boolean isCorrectAnswer, Integer order, Date createdDate) {
        this.text = text;
        this.isCorrectAnswer = isCorrectAnswer;
        this.order = order;
        this.createdDate = createdDate;
    }

    public Answer() {
    }
}
