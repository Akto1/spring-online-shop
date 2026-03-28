package com.example.demo.service;



import com.example.demo.dto.UserCreateDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.models.Roles;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
private final UserRepository userRepository;
public UserResponseDTO createUser( UserCreateDTO dto){
    System.out.println("CREATE USER called");
    User user = new User();
    user.setName(dto.getName());
    user.setPassword(dto.getPassword());
    user.setEmail(dto.getEmail());
    System.out.println("email from dto " + dto.getEmail());
    user.setRole(Roles.ROLE_USER);
if(dto.getEmail().equals("belinboris498@gmail.com")){
    user.setRole(Roles.ROLE_ADMIN);
}else{
    user.setRole(Roles.ROLE_USER);
}

    User savedUser = userRepository.save(user);
    return new UserResponseDTO(
            savedUser.getName(),
            savedUser.getRole(),
            savedUser.getEmail());
}
}
