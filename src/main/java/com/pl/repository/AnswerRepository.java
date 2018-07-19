package com.pl.repository;


import com.pl.domain.Answer;
import com.pl.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

//	int countByQuestion(Question question);
//
//	List<Answer> findByQuestionOrderByOrderAsc(Question question);

}
