package com.example.demo.models.entity;

import com.example.demo.models.DTO.AnswerDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.java.IntegerJavaType;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answers")
public class AnswersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    private int id_user;

    private int id_question;

    private String answer;

    public AnswersEntity(AnswerDTO answer) {
        this.id = answer.getId();
        this.id_user = answer.getId_user();
        this.id_question = answer.getId_question();
        this.answer = answer.getAnswer();
    }
}
