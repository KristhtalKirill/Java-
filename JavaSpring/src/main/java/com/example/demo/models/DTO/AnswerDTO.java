package com.example.demo.models.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AnswerDTO {
    private Integer id;

    private int id_user;

    private int id_question;

    private String answer;
}
