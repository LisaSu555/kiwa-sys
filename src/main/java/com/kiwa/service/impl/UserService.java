package com.kiwa.service.impl;

import com.kiwa.domain.BO.UserBo;
import com.kiwa.domain.User;
import com.kiwa.domain.VO.LoginDto;
import com.kiwa.mapper.UserMapper;
import com.kiwa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginDto login(User user) {
        LoginDto loginDto = new LoginDto();
        User login = userMapper.login(user);

        if (login == null){
            loginDto.setCode("400");
            loginDto.setMsg("username or password is wrong！");
            UserBo.setUser(user);
            return loginDto;
        }

        loginDto.setCode("200");
        loginDto.setMsg("login success!");
        loginDto.setUser(login);
        return loginDto;
    }
    public List<User> getAllUser() {
        System.out.println("current login user is "+UserBo.getUser().getUsername());
        return userMapper.getAllUser();
    }

    @Override
    public String register(User userFromFront) {
        String message = "";
        // 使用前台传来的用户名称查询用户
        User userFindByName = userMapper.getUserByName(userFromFront.getUsername());
        // 如果查询得到则说明该用户名称已被占用
        if(userFindByName != null){
            message = "this username already exist,change another one please";
            return message;
        }
        // can not find one go on insert
        int refCount = userMapper.insertUser(userFromFront);
        if(refCount != 1){
            message = "something has wrong when insert for register!";
            return message;
        }
        message = "register success";
        return message;
    }
}
