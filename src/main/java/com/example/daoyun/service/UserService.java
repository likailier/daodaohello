package com.example.daoyun.service;

import com.example.daoyun.domain.Login;
import com.example.daoyun.domain.User;

import java.util.List;

public interface UserService {

    int userLogin(Login login);
    User getUser(String phone);
    int checkPhone(String phone);
    int checkNum(int number);
    int register(Login login);
    int fastregister(String phone);
    User getUserByPhone(String phone);
    int userInfo(User user);


    //后端
    List<User> userList();
    int newUser(User user);
    int deleteUser(String phone);
}
