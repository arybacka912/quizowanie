package com.pl.rest;

import com.pl.domain.Question;
import com.pl.domain.Quiz;
import com.pl.domain.UserQuiz;
import com.pl.dto.QuestionDto;
import com.pl.dto.QuizowanieDto;

import com.pl.repository.QuestionRepository;
import com.pl.repository.UserQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class QuizUserControllerRest {

@Autowired
    UserQuizRepository userQuizRepository;

    QuestionRepository questionRepository;

    public List<QuestionDto> getQuestionListFromDto(List<QuestionDto> listQuestionDto) {

        //1. przejść pętlą po listQuestionDto (dla każdej pozycji odszukaj question w bazie) - utwórz listę z wynikami z bazy
        // questionRepository.find

        List<QuestionDto> resultListQuestion;
        resultListQuestion = new ArrayList<>();
        listQuestionDto.forEach(element -> resultListQuestion.add(getQuestionFromDto(element)));

        return resultListQuestion;
    }
       @GetMapping("/newQuiz")
        ResponseEntity<?> getQuestionFromDto(@RequestBody QuizowanieDto quizowanieDto) {
            // z obiektu quizowanieDto utwórz obiekt Quiz, wyciągnij z bazy UserQuiz, zapisz do bazy Quiz z uzupełniony UserQuizem

            Quiz quiz = new Quiz();

            quiz.setName(quizowanieDto.getUserName());
            quiz.setName(quizowanieDto.getNameQuiz());
            quiz.setDescription(quizowanieDto.getCreatedDate());
            List<QuestionDto> getQuestions = new ArrayList<>();
//            getQuestions.add(quizowanieDto.getQuestions());
//            quiz.setQuestions(quizowanieDto.getQuestions());
            quiz.setIsPublished(quizowanieDto.getPublished());

            UserQuiz userQuiz = userQuizRepository.findByUsername(quizowanieDto.getUserName());
            quiz.setUserQuiz(userQuiz);

            quiz.save(userQuiz);

            return quiz;
        }
    //QuestionDto->question
    private List<Question> getQuestionFromQuestionDto (List<QuestionDto> questionDtoFindId){
        List<Question> resultList1 = new ArrayList<>();
        questionDtoFindId.forEach(item -> {
            Question question = new Question();

//            question.setAnswers(item.getAnswers()); napisać zestaw metod conversis zmiany answer na answerDto! napisać answer ->answerDto
            question.setSign(item.getSign());
            question.setText(item.getText());
            question.setIsValid(item.isValid());

            resultList1.add(question);

        });

    }
}
