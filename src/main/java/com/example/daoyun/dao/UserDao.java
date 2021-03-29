package com.example.daoyun.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public abstract int getUserByMassage(@Param("username") String username, @Param("password") String password);
}
