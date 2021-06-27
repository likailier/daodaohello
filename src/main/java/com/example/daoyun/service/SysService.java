package com.example.daoyun.service;

import com.example.daoyun.domain.System;

import java.util.List;

public interface SysService {
    int insertSys(System sys);
    int checkSys(String key);
    int deleteSys(int id);
    int updateSys(System sys);
    List<System> selectSys();
}
