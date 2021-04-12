package com.example.daoyun.dao;

import com.example.daoyun.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public int userloginById(int loginUserId, String password);
    public int userloginByPhone(String loginUserPhone, String password);
    public int userloginByEmail(String loginUserEmail, String password);
    public int getUserByMassage(@Param("username") String username, @Param("password") String password);
}
