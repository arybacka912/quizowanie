package com.pl.rest;

import com.pl.domain.Question;
import com.pl.exception.EmptyQuizowanieException;
import com.pl.repository.QuestionRepository;
import com.pl.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class QuestionControllerRest {


    @Autowired
    public QuestionControllerRest(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    QuestionRepository questionRepository;


    @PostMapping("/newQuestion")
    ResponseEntity<Question> getQuizFromSth(@RequestBody Question question) {


        questionRepository.save(question);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping("/findQuestionById")
    public ResponseEntity<Question> getIdQuestion (@RequestParam (value = "id") int id) throws IOException {

        Optional<Question> question = questionRepository.findById(Long.valueOf(id));
        if (question.isPresent()) {
            return new ResponseEntity<>(question.get(), HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("findAllQuestions")
    public List<Question> getIdAnswer() throws IOException, EmptyQuizowanieException {
        return questionRepository.findAll();
    }

}
