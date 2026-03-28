package com.example.demo.controllers;

import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.models.Roles;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        if(user.getEmail().equals("belinboris498@gmail.com")){
            user.setRole(Roles.ROLE_ADMIN);
        }
        else{
            user.setRole(Roles.ROLE_USER);
        }
        userRepository.save(user);
        return "User created";
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
