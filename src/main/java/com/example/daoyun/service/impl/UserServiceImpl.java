package com.example.daoyun.service.impl;

import com.example.daoyun.bean.User;
import com.example.daoyun.dao.UserDao;
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
    UserDao userDao;

    @Override
    public int userLogin(User loginUser) {
        if (loginUser.getPhone() == null && loginUser.getEmail() == null && loginUser.getUserId()+"" == null){
            throw new SweetException( ResultCodeEnum.LoginError.getCode(),"登录名不能为空");
        }
        if (loginUser.getPhone()!= null){
            return userDao.userloginByPhone(loginUser.getPhone(),loginUser.getPassword());
        }
        if (loginUser.getEmail()!= null){
            return userDao.userloginByEmail(loginUser.getEmail(),loginUser.getPassword());
        }
        if (loginUser.getUserId()+"" != null){
            return userDao.userloginById(loginUser.getUserId(),loginUser.getPassword());
        }
        return 0;
    }
}
