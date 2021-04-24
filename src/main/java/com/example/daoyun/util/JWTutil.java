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
        Date IssueDate = new Date();

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.HOUR, 24 * 7);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)
                .withClaim("number", user.getNumber())
                .withClaim("name", user.getName()) // 存入claim的userId字段是int类型，而稍后要存入mysql的是String类型，解密后处理不当可能导致null
                .withExpiresAt(expiresDate) // 设置过期的日期
                .withIssuedAt(IssueDate) // 签发时间
                .withIssuer("auth0")
                .sign(Algorithm.HMAC256(SECRET)); // 加密
        return token;
    }

    public static Map<String, Claim> verifyToken(String token) throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try{
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new SweetException(ResultCodeEnum.LoginError.getCode(),"登录过期");
        }
        return jwt.getClaims();
    }

}
