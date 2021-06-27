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
    public int checkDictDetail(String code,String key) {
        return dictDao.checkDictDetail(code,key);
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
        dictDao.deleteDictDetailByCode(id);
        return dictDao.deleteDictType(id);
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
    public int changeDictSort(int id1, int id2) {
        int num1 = dictDao.selectDetailOrder(id1);
        int num2 = dictDao.selectDetailOrder(id2);
        int flag = 0;
        if (dictDao.changeDictSort(num2,id1)==1&&dictDao.changeDictSort(num1,id2)==1){
            flag = 1;
        }
        return flag;
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
