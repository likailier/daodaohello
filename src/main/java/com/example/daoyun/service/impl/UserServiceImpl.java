package com.example.daoyun.service.impl;

import com.example.daoyun.dao.LoginDao;
import com.example.daoyun.domain.Login;
import com.example.daoyun.domain.User;
import com.example.daoyun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public User getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }

    @Override
    public int userInfo(User user) {
        return userDao.userInfo(user);
    }

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    public int newUser(User user) {

        Login login = new Login();
        login.setPhone(user.getPhone());
        login.setPassword("123456");
        login.setRole(3);
        user.setRole(3);
        if (userDao.newUser(user)==1&&userDao.newLogin(login)==1){
            return 1;
        }
            return 0;
    }

    @Override
    public int deleteUser(String phone) {
        if (userDao.deleteUser(phone)==1 && userDao.deleteLogin(phone)==1){
            return 1;
        }
        return 0;
    }

    @Override
    public int checkPhone(String phone) {
        return userDao.checkPhone(phone);
    }

    @Override
    public int checkNum(int number) {
        return userDao.checkNum(number);
    }


}
