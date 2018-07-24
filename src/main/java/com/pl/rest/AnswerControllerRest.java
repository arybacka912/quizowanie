package com.pl.rest;

import com.pl.domain.Answer;
import com.pl.exception.EmptyQuizowanieException;
import com.pl.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class AnswerControllerRest {



    @Autowired
    public AnswerControllerRest(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    AnswerRepository answerRepository;


    @PostMapping("/newAnswer")
    ResponseEntity<Answer> getAnswerFromSth(@RequestBody Answer answer) {

         answerRepository.save(answer);

        return new ResponseEntity<>(answer, HttpStatus.OK);
    }


    @GetMapping("/findAnswerById")
    public ResponseEntity<Answer> getIdAnswer(@RequestParam ( value = "id") int id) throws IOException{

        Optional<Answer> answer = answerRepository.findById(Long.valueOf(id));
        if (answer.isPresent()) {
            return new ResponseEntity<>(answer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("findAllAnswers")
    public List<Answer> getIdAnswer() throws IOException, EmptyQuizowanieException {
        return answerRepository.findAll();
    }

    //answerRepository.findAll( getmapping

    //answerRepository.findbyid - getmapping z parametrem id
}
