package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UserService {
    private final List<User> users = new ArrayList<>();
    public void addUsers(User user) {
        users.add(user);
    }
    public List<User> getAllUsers() {
        return users;


    }
}

