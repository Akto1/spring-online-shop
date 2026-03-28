package com.example.demo.dto;

import com.example.demo.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {
    private String name;
    private Roles role;
    private String email;

}
