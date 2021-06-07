package com.example.daoyun.intercepors;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.example.daoyun.util.JWTutil;
import com.example.daoyun.util.ResultCodeEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        System.out.println("进入拦截器，生成token令牌："+token);
        if (token == null || token.equals("")) {
            returnResponse(response, "0", "请重新登录");
            return false;
        }
        try{
            JWTutil.verifyToken(token);
            return true;
        }catch (TokenExpiredException e){
            returnResponse(response,"0", "身份令牌超时");
        }catch (Exception e){
            returnResponse(response, "0", "身份令牌无效,请重新登录");
        }
        return false;
    }


    private void returnResponse(HttpServletResponse response, String code, String result) throws IOException {
        OutputStream out = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/json");
            Map<String, Object> map = new HashMap<>();
            map.put("code", code);
            map.put("msg", result);
            out = response.getOutputStream();
            out.write(JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue).getBytes("utf-8"));
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}
