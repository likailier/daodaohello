package com.example.daoyun.service.impl;

import com.example.daoyun.dao.SystemDao;
import com.example.daoyun.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.example.daoyun.domain.System;

@Transactional
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    SystemDao systemDao;

    @Override
    public int insertSys(System sys) {
        return systemDao.insertSys(sys);
    }

    @Override
    public int checkSys(String key) {
        return systemDao.checkSys(key);
    }

    @Override
    public int deleteSys(int id) {
        return systemDao.deleteSys(id);
    }

    @Override
    public int updateSys(System sys) {
        return systemDao.updateSys(sys);
    }

    @Override
    public List<System> selectSys() {
        return systemDao.selectSys();
    }
}
