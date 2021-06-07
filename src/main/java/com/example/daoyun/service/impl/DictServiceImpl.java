package com.example.daoyun.service.impl;

import com.example.daoyun.dao.DictDao;
import com.example.daoyun.domain.Dict;
import com.example.daoyun.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    DictDao dictDao;

    @Override
    public int insertDictDetail(Dict dictdetail) {
        return dictDao.insertDictDetail(dictdetail);
    }

    @Override
    public int insertDictType(Dict dicttype) {
        return dictDao.insertDictType(dicttype);
    }

    @Override
    public int deleteDictDetail(Integer id) {
        return dictDao.deleteDictDetail(id);
    }

    @Override
    public int deleteDictType(Integer id) {
        int state = 0;
        if (dictDao.deleteDictDetailByCode(id)==1 && dictDao.deleteDictType(id)==1){
            state = 1;
        }
        return state;
    }

    @Override
    public int updateDictDetail(Dict dictdetail) {
        return dictDao.updateDictDetail(dictdetail);
    }

    @Override
    public int updateDictType(Dict dicttype) {
        return dictDao.updateDictType(dicttype);
    }

    @Override
    public List<Dict> selectAllType() {
        return dictDao.selectAllType();
    }

    @Override
    public List<Dict> selectDictByCode(String code) {
        System.out.println(code);
        return dictDao.selectDetailByCode(code);
    }
}
