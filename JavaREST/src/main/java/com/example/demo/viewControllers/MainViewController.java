package com.example.demo.viewControllers;

import com.example.demo.models.DTO.AnswerDTO;
import com.example.demo.models.entity.AnswersEntity;
import com.example.demo.models.entity.UsersEntity;
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.repositories.QuestionRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainViewController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String greeting(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name_user = auth.getName();
        Optional<UsersEntity> user = userRepository.findByFirstName(name_user);
        if (user.isPresent()) {
            List<AnswersEntity> answers = answerRepository.findById_user(user.get().getId());
            List<Integer> as = new ArrayList<>();
            for (var a : answers) {
                as.add(a.getId_question());
            }

            if (as.isEmpty()) {
                model.addAttribute("questions", questionRepository.findAll());
            } else {
                model.addAttribute("questions",
                        questionRepository.findAllQuestionsThatNotAnsweredYet(as));
            }
        }
        model.addAttribute("answerDTO", new AnswerDTO());
        return "home.html";
    }
}
