package com.pl.dto;

import com.pl.domain.Answer;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;


public class QuestionDto extends ResourceSupport{

    private int sign;
    private String answers;
    private String text;
     private String createdDate;
    private boolean isValid;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionDto() {
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public String getAnswers()  {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }



    public QuestionDto(int sign, String answers, String createdDate, boolean isValid) {
        this.sign = sign;
        this.answers = answers;
        this.text = text;
        this.createdDate = createdDate;
        this.isValid = isValid;
    }
    @Override
    public String toString() {
        return "QuestionDto{" +
                "sign='" + sign + '\'' +
                "text='" + text + '\'' +
                ", answers='" + answers + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", isValid='" + isValid +
                '}';
    }
}