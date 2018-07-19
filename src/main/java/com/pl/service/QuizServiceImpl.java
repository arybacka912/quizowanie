package com.pl.service;



import com.pl.dto.QuizowanieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    public QuizServiceImpl(ParseService parseService) {
        this.parseService = parseService;

    }

    ParseService parseService;


    @Override
    public QuizowanieDto getQuizowanieDto(int id) throws IOException {
        return null;
    }

    @Override
    public void addToDb(QuizowanieDto quizowanieDto, int id) {
//        quizowanieJdbcService.addToQuizTable(quizowanieDto, id);

    }

    @Override
    public QuizowanieDto getQuizById(int id) {
return null;
//        return quizowanieJdbcService.getById(id);
    }
    }

