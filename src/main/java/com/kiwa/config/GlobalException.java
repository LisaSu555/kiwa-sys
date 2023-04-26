package com.kiwa.config;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;

import com.kiwa.utils.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@Configuration
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class GlobalException {

    @ExceptionHandler(SignatureVerificationException.class)
    public Map testException(SignatureVerificationException signatureVerificationException) {
        return R.succeed("签名异常");
    }

    @ExceptionHandler(TokenExpiredException.class)
    public Map testException(TokenExpiredException tokenExpiredException) {
        return R.succeed("token过期");
    }

    @ExceptionHandler(AlgorithmMismatchException.class)
    public Map testException(AlgorithmMismatchException AlgorithmMismatchException) {
        return R.succeed("加密算法不匹配");
    }

    @ExceptionHandler(Exception.class)
    public Map testException(Exception exception) {
        return R.succeed("出错了");
    }

}

