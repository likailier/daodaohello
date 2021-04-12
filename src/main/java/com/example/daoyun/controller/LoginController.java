package com.example.daoyun.controller;

import com.example.daoyun.bean.User;
import com.example.daoyun.dao.UserDao;
import com.example.daoyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userlogin")
    public int userLogin(@RequestBody User loginUser){
        return userService.userLogin(loginUser);
    }
}
