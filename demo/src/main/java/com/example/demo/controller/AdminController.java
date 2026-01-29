package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("admin")
public class AdminController {
    @GetMapping( "/test")
    public String testAdmin(){
        return "Доступ разрешен только админам!";
    }
    @GetMapping("/admin")
    public String welcome(){
        return "Welcome admin!";
    }
}
