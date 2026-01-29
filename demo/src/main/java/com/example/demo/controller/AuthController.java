//package com.example.demo.controller;
//
//import com.example.demo.dto.JwtResponse;
//import com.example.demo.dto.LoginRequest;
//import com.example.demo.dto.UserRegisterRequest;
//import com.example.demo.model.Role;
//import com.example.demo.model.User;
//import com.example.demo.repository.RoleRepository;
//import com.example.demo.repository.UserRepository;
//import com.example.demo.security.JwtUtil;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@RestController
//@RequestMapping("/auth")
//@AllArgsConstructor
//public class AuthController {
//    private final JwtUtil jwtUtil;
//    private final UserRepository userRepository;
//    private final PasswordEncoder encoder;
//    private final AuthenticationManager authenticationManager;
//    private final RoleRepository roleRepository;
//
//
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequest request) {
//        if(userRepository.existsByEmail(request.getEmail())){
//            return ResponseEntity.badRequest().body("Email is already taken!");
//        }
//
//        User user = new User();
//        user.setUsername(request.getUsername());
//        user.setEmail(request.getEmail());
//        user.setPassword(encoder.encode(request.getPassword()));
//
//        Role role = roleRepository.findByName("ROLE_ADMIN").
//                orElseThrow(()-> new UsernameNotFoundException("Role not found!"));
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        user.setRoles(roles);
//        userRepository.save(user);
//        User savedUser = userRepository.findByEmail(user.getEmail()).orElseThrow();
//
//        return ResponseEntity.ok("User registered as ADMIN");
//
//
//    }
//
//    @GetMapping("/check/roles/{email}")
//    public ResponseEntity<?> check(@PathVariable String email){
//        User u = userRepository.findByEmail(email).orElseThrow();
//        return ResponseEntity.ok(u.getRoles());
//    }
//
//    @PostMapping("/login")
//    public JwtResponse login(@RequestBody LoginRequest request) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
//
//        if (authentication.isAuthenticated()) {
//            String token = jwtUtil.generateToken(request.getEmail());
//            return new JwtResponse(token);
//
//        } else {
//            throw new RuntimeException("Invalid credentials!");
//        }
//    }
//}
