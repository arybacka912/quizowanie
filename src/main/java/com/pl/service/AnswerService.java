package com.pl.service;


import com.pl.domain.Answer;
import com.pl.domain.Question;

import java.util.List;

public interface AnswerService {
	Answer save(Answer answer);
	Answer find(Long id)  ;
    Answer getAnswerById(int id);
	Answer update(Answer newAnswer) ;

	void delete(Answer answer) ;

	List<Answer> findAnswersByQuestion(Question question);

	int countAnswersInQuestion(Question question);

    List<Answer> getAllAnswers();

}
