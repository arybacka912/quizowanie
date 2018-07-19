package com.pl.repository;


import com.pl.domain.Quiz;
import com.pl.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

	List<Quiz> findByIsPublishedTrue();

	List<Quiz> findByUser(User user);

	@Query("SELECT q FROM Quiz q WHERE q.name LIKE %?1%")
	List<Quiz> searchByName(String name);
}
