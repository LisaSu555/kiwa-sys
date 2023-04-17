package com.kiwa.mapper;

import com.kiwa.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User login(User user);

    List<User> getAllUser();
}
