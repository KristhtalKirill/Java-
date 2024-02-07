package com.example.demo.RestControllers;

import com.example.demo.models.entity.QuestionEntity;
import com.example.demo.repositories.QuestionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.example.demo.xsl.XSLTransform.getModelAndView;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/question")
    public Iterable<QuestionEntity> getQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/question/{id}")
    public @ResponseBody Optional<QuestionEntity> getQuestion(@PathVariable int id) {
        return questionRepository.findById(id);
    }

    @PostMapping("/question")
    public @ResponseBody QuestionEntity createQuestion(@RequestBody QuestionEntity question) {
        return questionRepository.save(question);
    }

    @DeleteMapping("/question/{id}")
    public @ResponseBody void deleteQuestion(@PathVariable int id) {
        questionRepository.deleteById(id);
    }
    @GetMapping(path = "xsl/question")
    public ModelAndView getStudent() throws JsonProcessingException {
        Iterable<QuestionEntity> list = questionRepository.findAll();
        return getModelAndView(list, "questionXSL");
    }
}
