package com.pl.service;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pl.dto.QuizowanieDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ParseService {


    public QuizowanieDto returnParsedQuiz(String content) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(content, QuizowanieDto.class);
    }
}