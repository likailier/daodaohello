package com.example.daoyun.dao;

import com.example.daoyun.domain.Login;
import com.example.daoyun.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao {
    public int userloginByPhone(String phone, String password);
    public User getUser(String phone);
    public int checkPhone(String phone);
    public int checkNum(int number);
    public int register(String phone, String password, int role);
    public int fastregister(String phone,int role);
    public int createUser(String phone,int role);
    public User getUserByPhone(String phone);
    public int userInfo(User user);


    //后端相关
    public List<User> userList();
    public int newUser(User user);
    public int newLogin(Login login);
    public int deleteUser(String phone);
    public int deleteLogin(String phone);

}
