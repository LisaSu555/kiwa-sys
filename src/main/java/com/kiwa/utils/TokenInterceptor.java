package com.kiwa.utils;

import com.alibaba.fastjson.JSONObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author laz
 * @date 2022/09/09 14:56
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        //获取到token
        String token = request.getHeader("token");
        if (token!=null){
            boolean result= TokenUtil.verify(token);
            if (result){
                System.out.println("you are already login pass!");
                return true;
            }
        }
        try {
            JSONObject json=new JSONObject();
            json.put("code","400");
            json.put("msg","you should login first");
            response.getWriter().append(json.toString());
            System.out.println("you should login first");
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}

