package com.pl;

import com.pl.domain.Answer;
import com.pl.domain.Question;
import com.pl.domain.Quiz;
import com.pl.domain.User;
import com.pl.repository.QuizRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class QuizowanieApp {

		private static final Logger log = LoggerFactory.getLogger(QuizowanieApp.class);

		public static void main(String[] args) {
			SpringApplication.run(QuizowanieApp.class);
		}


		@Bean
		public CommandLineRunner demo(QuizRepository quizRepository) {
			Date date = Calendar.getInstance().getTime();

			return (args) -> {
				// save a couple of customers
				List<Answer> answers = new ArrayList<>();
				Answer answer1 = new Answer("elphant",1, date);
				Answer answer2 = new Answer("whale",1, date);
				Answer answer3 = new Answer("manta",1 , date);
				answers.add(answer1);
				answers.add(answer2);
				answers.add(answer3);

				User user1 = new User("main@localhost", "user1",
						"user1", true, Calendar.getInstance().getTime());


				List<Question> questions = new ArrayList<>();
				Question question1 = new Question("The biggest animal?", 1, answers, answer2, date, true);


				Quiz quiz1 = new Quiz(user1, "quiz1",
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
				quizRepository.findByCreatedBy(new User("main@localhost", "user1",
						"user1", true, Calendar.getInstance().getTime()))
				.forEach(quizik -> {
					log.info(quizik.toString());
				});
				// for (Quiz bauer : quizRepository.findByLastName("Bauer")) {
				// 	log.info(bauer.toString());
				// }
				log.info("");
			};
		}

	}


