package com.kiwa.utils.system;

import com.kiwa.domain.User;
import jakarta.servlet.http.HttpServletRequest;

public class GetCurrentUser {
    public static User getCurrentUser(HttpServletRequest request){
        String token = request.getHeader("token");
        return TokenUtil.getCurrentUserByToken(token);
    }
}
