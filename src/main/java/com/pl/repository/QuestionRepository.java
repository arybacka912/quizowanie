package com.pl.repository;


import com.pl.domain.Question;
import com.pl.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
//	int countByQuiz(Quiz quiz);
//
//	int countByQuizAndIsValidTrue(Quiz quiz);
//
//	List<Question> findByQuizOrderByOrderAsc(Quiz quiz);
//
//	List<Question> findByQuizAndIsValidTrueOrderByOrderAsc(Quiz quiz);
}
