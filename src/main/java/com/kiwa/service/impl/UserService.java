package com.kiwa.service.impl;

import com.kiwa.domain.User;
import com.kiwa.domain.VO.LoginDto;
import com.kiwa.mapper.UserMapper;
import com.kiwa.service.IUserService;
import com.kiwa.utils.TokenUtil;
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
            return loginDto;
        }
        String token= TokenUtil.sign(login);

        loginDto.setCode("200");
        loginDto.setMsg("login success!");
        loginDto.setUser(login);
        loginDto.setToken(token);
        return loginDto;
    }
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
