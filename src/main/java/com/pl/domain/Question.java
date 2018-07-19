package com.pl.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Size(min = 2, max = 150, message = "The question should be between 2 and 150 characters")
	@NotNull(message = "Question text not provided")
	private String text;



	@Column(name = "q_order")
	private Integer order;


	@OneToMany
	private List<Answer> answers;


	@OneToOne
		private Answer correctAnswer;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Date createdDate;


		private Boolean isValid = false;

	public Date getCreatedDate() {
		return createdDate;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}





	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public Answer getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Question(String text, Integer order, List<Answer> answers, Answer correctAnswer, Date createdDate, Boolean isValid) {
		this.text = text;
		this.order = order;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		this.createdDate = createdDate;
		this.isValid = isValid;
	}
}
