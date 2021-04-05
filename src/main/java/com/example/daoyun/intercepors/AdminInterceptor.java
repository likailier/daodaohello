package com.example.daoyun.intercepors;

import com.example.daoyun.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            User user = (User) request.getSession().getAttribute("User");
            if (user != null){
                return true;
            }
            response.sendRedirect(request.getContextPath()+"/login");
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
