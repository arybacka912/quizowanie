package com.pl.service;

import com.pl.domain.Quiz;

import java.io.IOException;
import java.util.List;

public interface QuizService {

        Quiz getQuiz(int id) throws IOException;
        public void addToDb(Quiz quiz, int id);

        Quiz getQuizById(int id);

    List<Quiz> getAll();
}

