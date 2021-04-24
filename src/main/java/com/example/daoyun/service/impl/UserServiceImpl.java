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
        if (login.getPassword() == null){
            throw new SweetException(ResultCodeEnum.LoginError.getCode(),"密码不能为空");
        }
        if (login.getPhone() == null && login.getEmail() == null && login.getUser_number()+"" == null){
            throw new SweetException( ResultCodeEnum.LoginError.getCode(),"登录名不能为空");
        }
        if (login.getPhone() != null){
            return userDao.userloginByPhone(login.getPhone(),login.getPassword());
        }
        if (login.getEmail()!= null){
            return userDao.userloginByEmail(login.getEmail(),login.getPassword());
        }
        if (login.getUser_number()+"" != null){
            return userDao.userloginById(login.getUser_number(),login.getPassword());
        }
        return 0;
    }

    @Override
    public User getUser(int number) {
        return userDao.getUser(number);
    }
}
