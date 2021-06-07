package com.example.daoyun.service.impl;

import com.example.daoyun.dao.LoginDao;
import com.example.daoyun.domain.Login;
import com.example.daoyun.domain.User;
import com.example.daoyun.exception.SweetException;
import com.example.daoyun.service.UserService;
import com.example.daoyun.util.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    LoginDao userDao;

    @Override
    public int userLogin(Login login) {
        System.out.println("服务层"+login.getPhone()+login.getPassword());
            return userDao.userloginByPhone(login.getPhone(),login.getPassword());
    }

    @Override
    public User getUser(String phone) {
        return userDao.getUser(phone);
    }

    @Override
    public int register(Login login) {
        login.setRole(3);//默认为学生用户
        userDao.register(login.getPhone(),login.getPassword(),login.getRole());
        userDao.createUser(login.getPhone(),login.getRole());
        return 0;
    }

    @Override
    public int fastregister(String phone) {
        userDao.fastregister(phone,3);
        userDao.createUser(phone,3);
        return 0;
    }

    @Override
    public int checkPhone(String phone) {
        return userDao.checkPhone(phone);
    }


}
