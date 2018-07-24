package com.pl.rest;

import com.pl.domain.Quiz;
import com.pl.exception.EmptyQuizowanieException;
import com.pl.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class QuizowanieRest {

    private QuizService quizService;


    @Autowired
    public QuizowanieRest(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/quizId")
    public ResponseEntity<Quiz> getIdQuiz(@RequestParam(value = "id") int id) throws IOException {

        //pobrać z bazy quiz o id z parametru metody -> repository: metoda z quiz z wykożystaniem id = quiz -> quizDto - return

        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null) {
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getQuizAllId")
    public List<Quiz> getIdQuiz() throws IOException, EmptyQuizowanieException {

        return quizService.getAll();
    }


}
