package com.pl.javaClass;

import com.pl.repository.AnswerRepository;
import com.pl.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;

@Controller
@RequestMapping("app")
public class UserInfoController implements Serializable{


    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("custom-login");
        return mav;
    }
    @GetMapping("findByIdQuestions")
    public ModelAndView findById() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("question", questionRepository.findById(1L).get());
        mav.setViewName("question");
        return mav;
    }
    @GetMapping("getAllAnswers")
    public ModelAndView getAllAnswers() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("answer", answerRepository.getOne(1L));
        mav.setViewName("answer");
        return mav;
    }


    @GetMapping("error")
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        String errorMessage= "You are not authorized for the requested data.";
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("403");
        return mav;
    }
}