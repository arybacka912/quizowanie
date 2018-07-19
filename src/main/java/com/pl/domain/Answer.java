package com.pl.domain;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String text;

    private boolean isCorrectAnswer;

    private Integer sign;

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

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Answer [text= " + text + ",isCorrectAnswer= " + isCorrectAnswer + ", sign= " + sign + ", createdDate= " + createdDate
                + "]";
    }

    public Answer(String text, boolean isCorrectAnswer, Integer sign, Date createdDate) {
        this.text = text;
        this.isCorrectAnswer = isCorrectAnswer;
        this.sign = sign;
        this.createdDate = createdDate;
    }

    public Answer() {
    }
}
