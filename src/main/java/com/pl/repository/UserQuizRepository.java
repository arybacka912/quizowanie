package com.pl.repository;

import com.pl.domain.UserQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserQuizRepository extends JpaRepository<UserQuiz, Long> {
	UserQuiz findByEmail(String email);

	UserQuiz findByUsername(String username);
}
