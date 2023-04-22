package com.kiwa.controller;

import com.kiwa.domain.User;
import com.kiwa.utils.system.GetCurrentUser;
import jakarta.servlet.http.HttpServletRequest;

public class BaseController {
    public User getCurrentUser(HttpServletRequest request) {
        return GetCurrentUser.getCurrentUser(request);
    }
}
