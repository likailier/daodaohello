package com.example.daoyun.controller;

import com.example.daoyun.domain.Dict;
import com.example.daoyun.service.DictService;
import com.example.daoyun.service.impl.DictServiceImpl;
import com.example.daoyun.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictController {

    @Autowired
    DictService dictService;

    @PostMapping("/insertdictdetail")
    public Result insertDictDetail(@RequestBody Dict dictdetail){
        if (dictService.checkDictDetail(dictdetail.getCode(),dictdetail.getItemkey()) >= 1){
            return Result.failure("0","数值重复");
        }
        if (dictService.insertDictDetail(dictdetail) == 1){
            dictdetail.setSortNum(dictdetail.getId());
            dictService.updateDictDetail(dictdetail);
            return Result.success().setCode("200").setMsg("插入成功");
        }
        return Result.failure("0","插入失败");
    }

    @PostMapping("/insertdicttype")
    public Result insertDictType(@RequestBody Dict dicttype){
        if (dictService.insertDictType(dicttype) == 1){
            return Result.success().setCode("200").setMsg("插入成功");
        }
        return Result.failure("0","插入失败");
    }

    @DeleteMapping("/deletedictdetail/{id}")
    public Result deleteDictDetail(@PathVariable Integer id){
        if (dictService.deleteDictDetail(id) == 1){
            return Result.success().setCode("200").setMsg("删除成功");
        }
        return Result.failure("0","删除失败");
    }

    @DeleteMapping("/deletedicttype/{id}")
    public Result deleteDictType(@PathVariable Integer id){
        if (dictService.deleteDictType(id) == 1){
            return Result.success().setCode("200").setMsg("删除成功");
        }
        return Result.failure("0","删除失败");
    }

    @PutMapping("/updatedictdetail")
    public Result updateDictDetail(@RequestBody Dict dictdetail){
        if (dictService.updateDictDetail(dictdetail) == 1){
            return Result.success().setCode("200").setMsg("修改成功");
        }
        return Result.failure("0","修改失败");
    }

    @PutMapping("/updatedicttype")
    public Result updateDictType(@RequestBody Dict dicttype){
        if (dictService.updateDictType(dicttype) == 1){
            return Result.success().setCode("200").setMsg("修改成功");
        }
        return Result.failure("0","修改失败");
    }

    @PutMapping("/changedictsort/{id1}/{id2}")
    public Result changeDictSort(@PathVariable int id1,@PathVariable int id2){
        if (dictService.changeDictSort(id1,id2) == 1){
            return Result.success().setCode("200").setMsg("修改成功");
        }
        return Result.failure("0","修改失败");
    }

    @GetMapping("/alltype")
    public Result selectAllType(){
        List<Dict> list = dictService.selectAllType();
        return Result.success().setCode("200").setMsg("数据字典列表查询成功").setData(list);
    }

    @GetMapping("/detailbycode/{code}")
    public Result selectDetailByCode(@PathVariable String code){
        List<Dict> list = dictService.selectDictByCode(code);
        return Result.success().setCode("200").setMsg("数据字典详情查询成功").setData(list);
    }
}
