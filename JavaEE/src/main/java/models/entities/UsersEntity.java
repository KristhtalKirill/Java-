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

    private String role;
}
