package com.example.daoyun.service;

import com.example.daoyun.domain.Login;
import com.example.daoyun.domain.User;

public interface UserService {

    int userLogin(Login login);
    User getUser(int number);
}
