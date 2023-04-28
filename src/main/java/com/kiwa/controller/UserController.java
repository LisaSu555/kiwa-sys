package com.kiwa.controller;

import com.kiwa.domain.User;
import com.kiwa.domain.VO.LoginDto;
import com.kiwa.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author hp
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/authLogin")
    public LoginDto login(@RequestBody User user){
        return userService.login(user);
    }

    @ResponseBody
    @GetMapping("/list")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @ResponseBody
    @PostMapping("/authRegister")
    public String register(@RequestBody User userFromFront){
        return userService.register(userFromFront);
    }
}
