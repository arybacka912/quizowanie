package com.pl.rest;

import com.pl.domain.Quiz;
import com.pl.domain.UserQuiz;

import com.pl.repository.QuestionRepository;
import com.pl.repository.QuizRepository;
import com.pl.repository.UserQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController

public class QuizUserControllerRest {

@Autowired
    UserQuizRepository userQuizRepository;
@Autowired
    QuizRepository quizRepository;

    QuestionRepository questionRepository;

       @PostMapping("/newQuiz")
        ResponseEntity<Quiz> getQuestionFromDto(@RequestBody Quiz quiz) {


            UserQuiz userQuiz = userQuizRepository.findByUsername(quiz.getUserQuiz().getUsername());
//            quiz.setUserQuiz(userQuiz);

            quizRepository.save(quiz);

            return new ResponseEntity<>(quiz, HttpStatus.OK);
        }



}
