package com.kiwa.service;

import com.kiwa.domain.User;
import com.kiwa.domain.VO.LoginDto;
import java.util.List;

public interface IUserService {
    LoginDto login(User user);
    List<User> getAllUser();
    String register(User userFromFront);
}
