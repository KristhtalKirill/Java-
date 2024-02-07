package models.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.enterprise.inject.Model;

@Entity
@Model
@Setter
@Getter
@ToString
@AllArgsConstructor
@Table(name = "questions")
@NoArgsConstructor
public class QuestionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @NonNull
    private String txt;
}
