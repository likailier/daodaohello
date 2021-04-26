package com.example.daoyun.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.daoyun.domain.User;
import com.example.daoyun.exception.SweetException;


import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTutil {
    private static String SECRET = "zlwzlwzlw";

    public static String createToken(User user) throws Exception{

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 20);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)
                .withClaim("number",user.getNumber())
                .withClaim("name", user.getName()) // 存入claim的userId字段是int类型，而稍后要存入mysql的是String类型，解密后处理不当可能导致null
                .withClaim("role", user.getRole())
                .withClaim("phone",user.getPhone())
                .withExpiresAt(instance.getTime()) // 设置过期的日期
                .sign(Algorithm.HMAC256(SECRET)); // 加密
        System.out.println(token);
        return token;
    }

    public static void verifyToken(String token) throws UnsupportedEncodingException {
        try{
            JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        }catch (Exception e){
            throw e;
        }
    }

}
