package com.example.daoyun.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.daoyun.domain.System;

@Repository
public interface SystemDao {
    int insertSys(System sys);
    int checkSys(String key);
    int deleteSys(int id);
    int updateSys(System sys);
    List<System> selectSys();
}
