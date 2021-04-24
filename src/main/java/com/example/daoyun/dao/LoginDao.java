package com.example.daoyun.dao;

import com.example.daoyun.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    public int userloginById(int loginUserId, String password);
    public int userloginByPhone(String loginUserPhone, String password);
    public int userloginByEmail(String loginUserEmail, String password);
    public User getUser(int number);
}
