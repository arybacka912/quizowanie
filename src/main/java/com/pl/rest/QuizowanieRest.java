package com.pl.rest;

import com.pl.dto.QuizowanieDto;
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
        JdbcTemplate jdbcTemplate;

        @Autowired
        public QuizowanieRest(QuizService quizService) {
            this.quizService = quizService;
        }

        @RequestMapping("/quiz")
        public ResponseEntity<QuizowanieDto> getPokemon(@RequestParam(value = "id") int id) throws IOException {

            QuizowanieDto quizowanieDto = quizService.getQuizById(id);
            if (quizowanieDto != null) {
                return getPokemonDtoResponseEntity(id, quizowanieDto);
            }

            quizowanieDto = quizService.getQuizowanieDto(id);
            quizService.addToDb(quizowanieDto, id);
            return getPokemonDtoResponseEntity(id, quizowanieDto);

        }

        private ResponseEntity<QuizowanieDto> getPokemonDtoResponseEntity(@RequestParam(value = "id") int id, QuizowanieDto quizowanieDto) throws IOException {
            quizowanieDto.add(linkTo(methodOn(QuizowanieRest.class).getPokemon(id)).withSelfRel());
            return new ResponseEntity<>(quizowanieDto, HttpStatus.OK);
        }

        @GetMapping("/api/getAll")
        public List<QuizowanieDto> getPokemon() throws IOException, EmptyQuizowanieException {
            throw new EmptyQuizowanieException();
        }




}
