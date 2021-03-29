package com.example.daoyun.controller;

import com.example.daoyun.bean.Login;
import com.example.daoyun.bean.User;
import com.example.daoyun.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String Login(@RequestBody Login login){
        String str = "error";
        int count = userDao.getUserByMassage(login.getLogin_name(), login.getLogin_password());
        if (count > 0) str = "success";
        return str;
    }
}
