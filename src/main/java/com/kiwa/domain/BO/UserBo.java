package com.kiwa.domain.BO;

import com.kiwa.domain.User;
import lombok.Data;

@Data
public class UserBo{
    private String token;
    private String ipAddress;
    private String deviceMacAddress;
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserBo.user = user;
    }
}
