package com.pl.repository;


import com.pl.domain.Quiz;
import com.pl.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("QuizRepository")
public interface QuizRepository extends PagingAndSortingRepository<Quiz, Long> {

	List<Quiz> findByIsPublishedTrue();

	List<Quiz> findByCreatedBy(User user);

	@Query("SELECT q FROM Quiz q WHERE q.name LIKE %?1%")
	List<Quiz> searchByName(String name);
}
