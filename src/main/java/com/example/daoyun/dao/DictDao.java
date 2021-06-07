package com.example.daoyun.dao;

import com.example.daoyun.domain.Dict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictDao {
    int insertDictDetail(Dict dictdetail);
    int insertDictType(Dict dicttype);
    int deleteDictDetail(Integer id);
    int deleteDictDetailByCode(Integer id);
    int deleteDictType(Integer id);
    int updateDictDetail(Dict dictdetail);
    int updateDictType(Dict dicttype);
    List<Dict> selectAllType();
    List<Dict> selectDetailByCode(String code);
}
