package com.example.daoyun;

import com.example.daoyun.bean.User;
import com.example.daoyun.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DaoyunApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void Test(){
        User loginUser = new User(100000000,"123456");
        int i = userService.userLogin(loginUser);
        System.out.println(i);
    }

}
