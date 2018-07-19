package com.pl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

import java.util.Arrays;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuizowanieDto extends ResourceSupport{

        private int idQuiz;
        private String nameQuiz;
        private String descriptionQuiz;
        private String questions;
        private String createdDate;
        private boolean isPublished;



        @JsonProperty("abilities")
        private AbilitiesDto[] abilities;


        @JsonProperty("stats")
        private StatsDto[] statsDto;

        public QuizowanieDto() {
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

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
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

    public AbilitiesDto[] getAbilities() {
        return abilities;
    }

    public void setAbilities(AbilitiesDto[] abilities) {
        this.abilities = abilities;
    }

    public StatsDto[] getStatsDto() {
        return statsDto;
    }

    public void setStatsDto(StatsDto[] statsDto) {
        this.statsDto = statsDto;
    }

    public QuizowanieDto(int idQuiz, String nameQuiz, String descriptionQuiz, String questions, String createdDate,
                         boolean isPublished, AbilitiesDto[] abilities, StatsDto[] statsDto) {
        this.idQuiz = idQuiz;
        this.nameQuiz = nameQuiz;
        this.descriptionQuiz = descriptionQuiz;
        this.questions = questions;
        this.createdDate = createdDate;
        this.isPublished = isPublished;
        this.abilities = abilities;
        this.statsDto = statsDto;
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
                    ", abilities=" + Arrays.toString(abilities) +
                    ", statsDto=" + Arrays.toString(statsDto) +
                    '}';
        }

    }

