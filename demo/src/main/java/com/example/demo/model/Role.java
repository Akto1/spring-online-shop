//package com.example.demo.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "roles")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//
//public class Role implements GrantedAuthority {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false, unique = true)
//    private String name;
//
//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users = new HashSet<>();
//
//
//    @Override
//    public String getAuthority() {
//        return name;
//    }
//}