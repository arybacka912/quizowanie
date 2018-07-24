package com.pl.service;



import com.pl.domain.Answer;
import com.pl.domain.Question;
import com.pl.domain.Quiz;
import com.pl.domain.UserQuiz;
import com.pl.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    public QuizServiceImpl(ParseService parseService, QuizRepository quizRepository) {
        this.parseService = parseService;
        this.quizRepository = quizRepository;
    }

    ParseService parseService;
    QuizRepository quizRepository;

    @Override
    public Quiz getQuiz(int id) throws IOException {
        return null;
    }

    @Override
    public void addToDb(Quiz quiz, int id) {
//        quizowanieJdbcService.addToQuizTable(quiz, id);

    }

    @Override
    public Quiz getQuizById(int id) {
        Optional<Quiz> quizFindId = quizRepository.findById(Long.valueOf(id));

        if (!quizFindId.isPresent()) {
            System.out.println("Quiz " + id + " not found");
            return null;
        }

        Quiz returnQuiz = getDtoFromQuiz(quizFindId.get());


        return returnQuiz;
    }

    @Override
    public List<Quiz> getAll() {
        List<Quiz> quizList = quizRepository.findAll();
        List<Quiz> resultList;
        resultList = new ArrayList<>();
        quizList.forEach(element -> resultList.add(getDtoFromQuiz(element)));
        //quiz wyciągnąć wszystkie elementy , zamienić na dto i dodać do resultList  (forEach, for z wykorzystaniem getDtoFromQuiz)

        return resultList;
    }

//
//    @Override
//    public Quiz save(Quiz quiz, UserQuiz userQuiz) {
//        quiz.setCreatedBy(userQuiz);
//        return quizRepository.save(quiz);
//    }

//    @Override
//    public Quiz update(Quiz newQuiz) {
//        Quiz currentQuiz = find(newQuiz.getName());
//
//        mergeQuiz(currentQuiz, newQuiz);
//        return quizRepository.save(currentQuiz);
//    }

    private void mergeQuiz(Quiz currentQuiz, Quiz newQuiz) {
        currentQuiz.setName(newQuiz.getName());
        currentQuiz.setDescription(newQuiz.getDescription());
    }

//    @Override
//    public Quiz find(Long id) {
//        Quiz quiz = quizRepository.findOne(id);
//
//
//        return quiz;
//    }

    private Quiz getDtoFromQuiz(Quiz quizFindId) {
        Quiz quiz = new Quiz();

        quiz.setName(quizFindId.getName());
        quiz.setDescription(quizFindId.getDescription());
        quiz.setQuestions(getQuestionDtoFromQuestion(quizFindId.getQuestions()));
        quiz.setIsPublished(quizFindId.getIsPublished());
        quiz.setUserQuiz(quizFindId.getUserQuiz());

        return quiz;

    }

//    Question - dto
    private Question getQuestionFromQuestionDto (Question questionDtoFindId){
        Question question = new Question();

//        question.setAnswers(questionDtoFindId.getAnswers());
        question.setIsValid(questionDtoFindId.getIsValid());
        question.setSign(questionDtoFindId.getSign());
        question.setText(questionDtoFindId.getText());

        return question;

    }

    private List<Question> getQuestionDtoFromQuestion (List<Question> questionFindId){
        List<Question> resultList = new ArrayList<>();
        questionFindId.forEach(item -> {
            Question question = new Question();

            question.setAnswers(item.getAnswers());
            question.setIsValid(item.getIsValid());
            question.setSign(item.getSign());
            question.setText(item.getText());

            resultList.add(question);

        });




return  resultList;
    }


}


