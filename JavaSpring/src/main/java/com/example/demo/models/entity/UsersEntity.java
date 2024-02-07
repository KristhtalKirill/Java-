package com.example.demo.models.entity;

import com.example.demo.models.roles.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.descriptor.java.IntegerJavaType;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    private String firstName;

    private String lastName;

    private int password;

    private String email;

    @NonNull
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
