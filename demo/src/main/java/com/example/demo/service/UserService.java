//package com.example.demo.service;
//
//import com.example.demo.dto.UserRegisterRequest;
//import com.example.demo.model.Role;
//import com.example.demo.model.User;
//import com.example.demo.repository.RoleRepository;
//import com.example.demo.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//    private final PasswordEncoder encoder;
//
//
//    public String registerUser(UserRegisterRequest request) {
//        if (userRepository.existsByEmail(request.getEmail())) {
//            return "User with this email is already exists!";
//        }
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setPassword(encoder.encode(request.getPassword()));
//        user.setEmail(request.getEmail());
//
//        Role userRole = roleRepository.findByName("ROLE_ADMIN")
//                .orElseGet(() -> {
//                    Role role = new Role();
//                    role.setName("ROLE_USER");
//                    return roleRepository.save(role);
//                });
//        Set<Role> roles = new HashSet<>();
//        roles.add(userRole);
//        user.setRoles(roles);
//        userRepository.save(user);
//        return "User registered successfully";
//    }
//}
//
