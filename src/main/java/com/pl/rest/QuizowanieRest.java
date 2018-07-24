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
        public QuizowanieRest(QuizService quizService) {
            this.quizService = quizService;
        }

        @GetMapping("/quizId")
        public ResponseEntity<QuizowanieDto> getIdQuiz(@RequestParam(value = "id") int id) throws IOException {

            //pobrać z bazy quiz o id z parametru metody -> repository: metoda z quiz z wykożystaniem id = quiz -> quizDto - return

            QuizowanieDto quizowanieDto = quizService.getQuizById(id);
            if (quizowanieDto != null) {
                return getQuizowanieDtoResponseEntity(id, quizowanieDto);
            }

            quizowanieDto = quizService.getQuizowanieDto(id);
            quizService.addToDb(quizowanieDto, id);
            return getQuizowanieDtoResponseEntity(id, quizowanieDto);

        }

    @GetMapping("/getQuizAllId")
    public List<QuizowanieDto> getIdQuiz() throws IOException, EmptyQuizowanieException {

        return quizService.getAll();
    }

    private ResponseEntity<QuizowanieDto> getAllQuizowanieDtoResponseEntity(@RequestParam(value = "id") int id,
                                                                            QuizowanieDto quizowanieDto) throws IOException{
        quizowanieDto.add(linkTo(methodOn(QuizowanieRest.class).getIdQuiz(id)).withSelfRel());
        return new ResponseEntity<>(quizowanieDto, HttpStatus.OK);
    }

        private ResponseEntity<QuizowanieDto> getQuizowanieDtoResponseEntity(@RequestParam(value = "id") int id,
                                                                             QuizowanieDto quizowanieDto) throws IOException {
            quizowanieDto.add(linkTo(methodOn(QuizowanieRest.class).getIdQuiz(id)).withSelfRel());
            return new ResponseEntity<>(quizowanieDto, HttpStatus.OK);
        }








}
