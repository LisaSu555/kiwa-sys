package com.kiwa.config;

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

        //������������ȷ�һ��option����ֱ�ӷ�������״̬��ͨ��������
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        //��ȡ��token
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

