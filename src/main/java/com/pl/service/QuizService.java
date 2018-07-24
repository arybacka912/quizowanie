package com.pl.service;

import com.pl.dto.QuizowanieDto;

import java.io.IOException;
import java.util.List;

public interface QuizService {

        QuizowanieDto getQuizowanieDto(int id) throws IOException;
        public void addToDb(QuizowanieDto quizowanieDto, int id);

        QuizowanieDto getQuizById(int id);

    List<QuizowanieDto> getAll();
}

