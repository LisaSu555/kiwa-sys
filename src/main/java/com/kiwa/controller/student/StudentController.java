package com.kiwa.controller.student;

import com.kiwa.controller.BaseController;
import com.kiwa.domain.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController {

    /**
     *
     * 项目搭建后测试请求是否成功
     * @return 测试字段
     */
    @GetMapping("/hello")
    public String hello(){
        return "successful";
    }

    /**
     * 得到当前登录用户的测试
     * @return 用户对象的名字
     */
    @GetMapping("/loginUser")
    public String user(HttpServletRequest request) {
        User currentUser = getCurrentUser(request);
        return currentUser.getUsername();
    }
}
