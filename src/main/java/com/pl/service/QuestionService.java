package com.pl.service;


import com.pl.domain.Answer;
import com.pl.domain.Question;
import com.pl.domain.Quiz;

import java.util.List;

public interface QuestionService {
	Question save(Question question);
	Question find(Long id);

    Question getQuestionById(int id);

	List<Question> findQuestionsByQuiz(Quiz quiz);

	List<Question> findValidQuestionsByQuiz(Quiz quiz);

    List<Question> getAllQuestions();
	Boolean checkIsCorrectAnswer(Question question, Long answer_id);

	void setCorrectAnswer(Question question, Answer answer);

	Answer getCorrectAnswer(Question question);

	Answer addAnswerToQuestion(Answer answer, Question question);

	int countQuestionsInQuiz(Quiz quiz);

	int countValidQuestionsInQuiz(Quiz quiz);
}
