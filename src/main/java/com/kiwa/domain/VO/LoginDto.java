package com.kiwa.domain.VO;

import com.kiwa.domain.User;
import lombok.Data;

@Data
public class LoginDto {
    private String code;
    private String msg;
    private User user;
    private String token;

    @Override
    public String toString() {
        return "LoginDto{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}