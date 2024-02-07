package models.entities;

import jakarta.enterprise.inject.Model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Model
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
    private int id;

    private int id_user;

    private int id_question;

    private String answer;
}
