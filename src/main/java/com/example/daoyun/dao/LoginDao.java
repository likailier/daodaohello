package com.example.daoyun.dao;

import com.example.daoyun.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    public int userloginByPhone(String phone, String password);
    public User getUser(String phone);
    public int checkPhone(String phone);
    public int register(String phone, String password, int role);
}
