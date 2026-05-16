package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserCreateDTO {
    @NotNull
    private String name;
    @Size(min = 4)
    private String password;
    @Email
    private String email;

}
