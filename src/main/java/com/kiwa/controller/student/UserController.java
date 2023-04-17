package com.kiwa.controller.student;

import com.kiwa.domain.User;
import com.kiwa.domain.VO.LoginDto;
import com.kiwa.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginDto login(@RequestBody User user){
        return userService.login(user);
    }

    @GetMapping("/list")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/register")
    public String register(@RequestBody User userFromFront){
        return userService.register(userFromFront);
    }
}
