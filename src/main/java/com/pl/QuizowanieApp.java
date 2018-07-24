package com.pl;

import com.pl.domain.Answer;
import com.pl.domain.Question;
import com.pl.domain.Quiz;
import com.pl.domain.UserQuiz;
import com.pl.repository.AnswerRepository;
import com.pl.repository.QuestionRepository;
import com.pl.repository.QuizRepository;
import com.pl.repository.UserQuizRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class QuizowanieApp {

		private static final Logger log = LoggerFactory.getLogger(QuizowanieApp.class);

		public static void main(String[] args) {
			SpringApplication.run(QuizowanieApp.class);
		}


		@Bean
		public CommandLineRunner demo(QuizRepository quizRepository, AnswerRepository answerRepository,
									  QuestionRepository questionRepository, UserQuizRepository userQuizRepository) {
			Date date = Calendar.getInstance().getTime();

			return (args) -> {
				// save a couple of customers
				List<Answer> answers = new ArrayList<>();
				Answer answer1 = new Answer("elphant",false, 1, date);
				Answer answer2 = new Answer("whale",true, 1, date);
				Answer answer3 = new Answer("manta",false, 1 , date);
				answers.add(answer1);
				answers.add(answer2);
				answers.add(answer3);

				answerRepository.save(answer1);
				answerRepository.save(answer2);
				answerRepository.save(answer3);
							UserQuiz userQuiz1 = new UserQuiz("main@localhost", "user1",
						"user1", true, Calendar.getInstance().getTime());

				userQuizRepository.save(userQuiz1);

				List<Question> questions = new ArrayList<>();
				Question question1 = new Question("The biggest animal?", 1, answers, date, true);

				questionRepository.save(question1);

				Quiz quiz1 = new Quiz(userQuiz1, "quiz1",
						"animals", questions, Calendar.getInstance().getTime(), true);


				quizRepository.save(quiz1);


				// fetch all customers
				log.info("Quizowaniey znalezione z findAll():");
				log.info("-------------------------------");
				for (Quiz quiz : quizRepository.findAll()) {
					log.info(quiz.toString());
				}
				log.info("");

				// fetch an individual customer by ID
				quizRepository.findByIsPublishedTrue()
						.forEach(quiz -> {
							log.info("Quiz znaleziony z findById(1):");
							log.info("--------------------------------");
							log.info(quiz.toString());
							log.info("");
						});

				// fetch customers by last name
				log.info("Quiz found with findByLastName('quiz'):");
				log.info("--------------------------------------------");
				quizRepository.findByUserQuiz(userQuiz1)
				.forEach(quiz -> {
					log.info(quiz.toString());
				});


				log.info("");
			};
		}

	}


