package com.example.demo.RestControllers;

import com.example.demo.models.entity.QuestionEntity;
import com.example.demo.models.entity.UsersEntity;
import com.example.demo.repositories.UserRepository;
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
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public Iterable<UsersEntity> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public @ResponseBody Optional<UsersEntity> getUser(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    public @ResponseBody UsersEntity createUser(@RequestBody UsersEntity usersEntity) {
        return userRepository.save(usersEntity);
    }

    @DeleteMapping("/user/{id}")
    public @ResponseBody void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping(path = "xsl/user")
    public ModelAndView getUser() throws JsonProcessingException {
        Iterable<UsersEntity> list = userRepository.findAll();
        return getModelAndView(list, "userXSL");
    }
}
