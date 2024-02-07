package com.example.demo.models.DTO;

import com.example.demo.models.roles.RoleEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.descriptor.java.IntegerJavaType;

@Getter
@Setter
public class UserDTO {
    private int id;

    private String firstName;

    private String lastName;

    private int password;

    private String email;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
