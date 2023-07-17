package com.kiwa.controller;

import com.kiwa.domain.User;
import com.kiwa.domain.VO.LoginDto;
import com.kiwa.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //@ResponseBody
    @PostMapping("/authLogin")
    public String login(@RequestBody User user, Model model){
        LoginDto login = userService.login(user);
        model.addAttribute("user",login);
        return "redirect:price/priceList";
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
