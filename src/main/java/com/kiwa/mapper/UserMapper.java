package com.kiwa.mapper;

import com.kiwa.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User login(User user);

    List<User> getAllUser();

    /**
     * 使用前段传递的用户名称查询数据库用户
     * 为了实现注册的一个小验证
     * @param frontUsername 来自前台的用户名
     * @return 查找到的用户对象
     */
    User getUserByName(@Param("frontUsername") String frontUsername);

    /**
     * add a user
     * @param userFromFront user from front
     * @return ref count
     */
    int insertUser(@Param("userFromFront") User userFromFront);
}
