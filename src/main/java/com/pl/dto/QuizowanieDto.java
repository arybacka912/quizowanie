package com.pl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuizowanieDto extends ResourceSupport{

        private int idQuiz;
        private String nameQuiz;
        private String descriptionQuiz;
        private List<QuestionDto> questions;
        private String createdDate;
        private boolean isPublished;
        private String userName;



        public QuizowanieDto() {
        }

    public void getPublished(boolean published) {
        isPublished = published;
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public String getNameQuiz() {
        return nameQuiz;
    }

    public void setNameQuiz(String nameQuiz) {
        this.nameQuiz = nameQuiz;
    }

    public String getDescriptionQuiz() {
        return descriptionQuiz;
    }

    public void setDescriptionQuiz(String descriptionQuiz) {
        this.descriptionQuiz = descriptionQuiz;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean isPublished) {
        isPublished = isPublished;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }





        @Override
        public String toString() {
            return "QuizowanieDto{" +
                    "idQuiz='" + idQuiz + '\'' +
                    ", nameQuiz='" + nameQuiz + '\'' +
                    ", descriptionQuiz='" + descriptionQuiz + '\'' +
                    ", questions='" + questions + '\'' +
                    ", createdDate='" + createdDate + '\'' +
                    ", isPublished='" + isPublished + '\'' +
                    ", userName=" + userName +
                    '}';
        }

    }

