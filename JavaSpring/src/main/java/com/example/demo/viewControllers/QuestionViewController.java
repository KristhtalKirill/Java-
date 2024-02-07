package com.example.demo.viewControllers;

import com.example.demo.models.DTO.QuestionDTO;
import com.example.demo.models.entity.QuestionEntity;
import com.example.demo.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@EnableMethodSecurity
@PreAuthorize("hasRole('ADMIN')")
public class QuestionViewController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/question")
    public String getQuestion(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        model.addAttribute("questionDTO", new QuestionDTO());
        model.addAttribute("question", new QuestionDTO());
        return "admin/question.html";
    }

    @PostMapping("/addquestion")
    public String createQuestion(@Validated QuestionDTO question) {
        questionRepository.save(new QuestionEntity((int) (questionRepository.count() + 1), question.getTxt()));
        return "redirect:/question";
    }

    @PostMapping("/deleteQuestion")
    public String deleteQuestion(@Validated QuestionDTO questionDTO) {
        int id = questionDTO.getId();
        questionRepository.deleteById(id);
        return "redirect:/question";
    }
}
