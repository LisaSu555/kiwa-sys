package com.kiwa.config;

import com.alibaba.fastjson.JSONObject;
import com.kiwa.controller.BaseController;
import com.kiwa.domain.BO.BaseUserInfo;
import com.kiwa.domain.Enum.UserInfoEnu;
import com.kiwa.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        String token = request.getHeader("token");
        if (token!=null){
            boolean result= TokenUtil.verify(token);
            if (result){
                User user = TokenUtil.getCurrentUserByToken(token);
                BaseUserInfo.set(UserInfoEnu.user.getCode(), user.getUsername());
                System.out.println("you are already login pass!");
                return true;
            }
        }
        try {
            JSONObject json=new JSONObject();
            json.put("code","400");
            json.put("msg","you should login first");
            response.getWriter().append(json.toString());
            //response.sendRedirect("/user/login");
            System.out.println("you should login first");
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}

