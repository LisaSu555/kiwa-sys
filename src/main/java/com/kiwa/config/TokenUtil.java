package com.kiwa.config;

import com.kiwa.domain.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;

public class TokenUtil {
    
    //token到期时间60s
    private static final long EXPIRE_TIME= 60*1000;
    //密钥盐
    private static final String TOKEN_SECRET="123456qwertyuiop789";

    /**
     * 创建一个token
     * @param user
     * @return
     */
    public static String sign(User user){
        String token=null;
        try {
            Date expireAt=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            token = JWT.create()
                    //发行人
                    .withIssuer("auth0")
                    //存放数据
                    .withClaim("username",user.getUsername())
                    .withClaim("password",user.getPassword())
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException|JWTCreationException je) {

        }
        return token;
    }
    /**
     * 对token进行验证
     * @param token
     * @return
     */
    public static Boolean verify(String token){
        try {
            //创建token验证器
            JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
        } catch (IllegalArgumentException |JWTVerificationException e) {
            //抛出错误即为验证不通过
            return false;
        }
        return true;
    }

    /**
     * 获取用户名
     */
    public static String getUserName(String token){
        try{
            DecodedJWT jwt=JWT.decode(token);
            return  jwt.getClaim("username").asString();
        }catch (JWTDecodeException e)
        {
            return null;
        }
    }

    public static User getCurrentUserByToken(String token){
        User user = new User();
        user.setUsername(getUserName(token));
        return user;
    }
}
