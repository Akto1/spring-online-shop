package com.example.demo.controllers;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.dto.UserCreateDTO;
import com.example.demo.models.Roles;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.JwtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@Valid @RequestBody UserCreateDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        
        encoder.encode(user.getPassword());
        if(!user.getEmail().endsWith("@gmail.com") &&  !user.getEmail().endsWith("@mail.ru")){
            throw new UserNotFoundException("Not correct mail!");
        }
        if(user.getEmail().equals("belinboris498@gmail.com")){
            user.setRole(Roles.ROLE_ADMIN);
        }
        else{
            user.setRole(Roles.ROLE_USER);
        }
        userRepository.save(user);
        return "User created";
    }

    @PutMapping("/give/admin/id/{id}")
    public String changeRole(@PathVariable Long id){
        User existinguser = userRepository.findById(id).orElseThrow();
        existinguser.setRole(Roles.ROLE_ADMIN);
        userRepository.save(existinguser);
        return "Role for user with id " + existinguser.getId() + " has been changed!";
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        User existingUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow();
        if(!encoder.matches(user.getPassword(), existingUser.getPassword())){
            throw new UserNotFoundException("User not found");
        }
        return jwtService.generateToken(existingUser.getEmail());
    }
}
