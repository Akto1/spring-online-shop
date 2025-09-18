//package com.example.demo;
//
//import com.example.demo.service.UserService;
//import com.example.demo.model.User;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class UserController {
//    private final UserService userService;
//    public UserController(UserService userService){
//        this.userService = userService;
//    }
//    @PostMapping("/register")
//    public String registerUser(@RequestBody User user){
//        userService.addUsers(user);
//        return "User " + user.getName() + " Age " + user.getAge() + " Email " + user.getEmail();
//    }
//    @GetMapping("/users")
//    public List<User> getUsers(){
//        return userService.getAllUsers();
//
//
//    }
//}
