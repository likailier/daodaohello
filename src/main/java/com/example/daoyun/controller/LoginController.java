package com.example.daoyun.controller;

import com.example.daoyun.domain.Login;
import com.example.daoyun.domain.User;
import com.example.daoyun.service.UserService;
import com.example.daoyun.util.JWTutil;
import com.example.daoyun.util.Result;
import com.example.daoyun.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userlogin")
    public Result userLogin(@RequestBody Login login){
        String token;
        User user = userService.getUser(login.getUser_number());

        try{
            token = JWTutil.createToken(user);
        } catch (Exception e) {
            return Result.failure(ResultCodeEnum.LoginError);
        }
        return Result.success().setCode(ResultCodeEnum.Login.getCode()).setMsg("登陆成功").setData(token);

    }

    @RequestMapping("/tokentest")
    public Result hello(){
        String str = "测试token成功";
        return Result.success().setCode(ResultCodeEnum.OK.getCode()).setMsg(str);
    }
}
