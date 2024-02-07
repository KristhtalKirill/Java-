package com.example.demo.models.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.java.IntegerJavaType;

@Setter
@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @NonNull
    private String txt;
}
