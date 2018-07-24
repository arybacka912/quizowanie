package com.pl.service;



import com.pl.domain.Answer;
import com.pl.domain.Question;
import com.pl.domain.Quiz;
import com.pl.domain.UserQuiz;
import com.pl.dto.QuestionDto;
import com.pl.dto.QuizowanieDto;
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
    public QuizowanieDto getQuizowanieDto(int id) throws IOException {
        return null;
    }

    @Override
    public void addToDb(QuizowanieDto quizowanieDto, int id) {
//        quizowanieJdbcService.addToQuizTable(quizowanieDto, id);

    }

    @Override
    public QuizowanieDto getQuizById(int id) {
        Optional<Quiz> quizFindId = quizRepository.findById(Long.valueOf(id));

        if (!quizFindId.isPresent()) {
            System.out.println("Quiz " + id + " not found");
            return null;
        }

        QuizowanieDto returnQuiz = getDtoFromQuiz(quizFindId.get());


        return returnQuiz;
    }

    @Override
    public List<QuizowanieDto> getAll() {
        List<Quiz> quizList = quizRepository.findAll();
        List<QuizowanieDto> resultList;
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

    private QuizowanieDto getDtoFromQuiz(Quiz quizFindId) {
        QuizowanieDto quizowanieDto = new QuizowanieDto();

        quizowanieDto.setNameQuiz(quizFindId.getName());
        quizowanieDto.setUserName(quizFindId.getUserQuiz().toString());
        quizowanieDto.setDescriptionQuiz(quizFindId.getDescription());
        quizowanieDto.setQuestions(getQuestionDtoFromQuestion(quizFindId.getQuestions()));
        quizowanieDto.setCreatedDate(quizFindId.getCreatedDate().toString());
        quizowanieDto.setIsPublished(quizFindId.getIsPublished());

        return quizowanieDto;

    }

//    Question - dto
    private Question getQuestionFromQuestionDto (QuestionDto questionDtoFindId){
        Question question = new Question();

//        question.setAnswers(questionDtoFindId.getAnswers());
        question.setIsValid(questionDtoFindId.isValid());
        question.setSign(questionDtoFindId.getSign());
        question.setText(questionDtoFindId.getText());

        return question;

    }

    private List<QuestionDto> getQuestionDtoFromQuestion (List<Question> questionFindId){
        List<QuestionDto> resultList = new ArrayList<>();
        questionFindId.forEach(item -> {
            QuestionDto questionDto = new QuestionDto();

            questionDto.setAnswers(item.getAnswers().toString());
            questionDto.setCreatedDate(item.getCreatedDate().toString());
            questionDto.setSign(item.getSign());
            questionDto.setValid(item.getIsValid());
            questionDto.setText(item.getText());

            resultList.add(questionDto);

        });




return  resultList;
    }


}


