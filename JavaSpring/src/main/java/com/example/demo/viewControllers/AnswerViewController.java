package com.example.demo.viewControllers;

import com.example.demo.models.DTO.AnswerDTO;
import com.example.demo.models.entity.AnswersEntity;
import com.example.demo.models.entity.UsersEntity;
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AnswerViewController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping("/answer")
    public String createQuestion(@Validated AnswerDTO answer) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<UsersEntity> user = userRepository.findByFirstName(auth.getName());
        user.ifPresent(usersEntity -> answer.setId_user(usersEntity.getId()));
        answer.setId((int) (answerRepository.count() + 1));

        answerRepository.save(new AnswersEntity(answer));
        return "redirect:/";
    }
}
