package com.example.daoyun.service;

import com.example.daoyun.domain.Dict;

import java.util.List;

public interface DictService {

    int insertDictDetail(Dict dictdetail);
    int checkDictDetail(String code,String key);
    int insertDictType(Dict dicttype);
    int deleteDictDetail(Integer id);
    int deleteDictType(Integer id);
    int updateDictDetail(Dict dictdetail);
    int updateDictType(Dict dicttype);
    int changeDictSort(int id1,int id2);
    List<Dict> selectAllType();
    List<Dict> selectDictByCode(String code);
}
