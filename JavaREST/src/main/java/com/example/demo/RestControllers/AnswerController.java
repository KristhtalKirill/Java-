package com.example.demo.RestControllers;

import com.example.demo.models.entity.AnswersEntity;
import com.example.demo.models.entity.QuestionEntity;
import com.example.demo.repositories.AnswerRepository;
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
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/answer")
    public Iterable<AnswersEntity> getAnswers() {
        return answerRepository.findAll();
    }

    @GetMapping("/answer/{id}")
    public @ResponseBody Optional<AnswersEntity> getAnswer(@PathVariable int id) {
        return answerRepository.findById(id);
    }

    @PostMapping("/answer")
    public @ResponseBody AnswersEntity createQuestion(@RequestBody AnswersEntity question) {
        return answerRepository.save(question);
    }

    @DeleteMapping("/answer/{id}")
    public @ResponseBody void deleteQuestion(@PathVariable int id) {
        answerRepository.deleteById(id);
    }

    @GetMapping(path = "xsl/answer")
    public ModelAndView getStudent() throws JsonProcessingException {
        Iterable<AnswersEntity> list = answerRepository.findAll();
        return getModelAndView(list, "answerXSL");
    }
}
