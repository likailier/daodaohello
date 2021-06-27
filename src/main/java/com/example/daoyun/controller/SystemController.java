package com.example.daoyun.controller;

import com.example.daoyun.domain.System;
import com.example.daoyun.service.SysService;
import com.example.daoyun.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SystemController {

    @Autowired
    SysService sysService;

    @PostMapping("/insertsys")
    public Result insertSys(@RequestBody System sys){
        if (sysService.checkSys(sys.getPkey()) > 0){
            return Result.failure("0","关键字重复");
        }
        if (sysService.insertSys(sys) == 1){
            return Result.success().setCode("200").setMsg("插入成功");
        }
        return Result.failure("0","插入失败");
    }

    @DeleteMapping("/deletesys/{id}")
    public Result deleteSys(@PathVariable int id){
        if (sysService.deleteSys(id) == 1){
            return Result.success().setCode("200").setMsg("删除成功");
        }
        return Result.failure("0","删除失败");
    }

    @PutMapping("/updatesys")
    public Result updateSys(@RequestBody System sys){
        if (sysService.updateSys(sys) == 1){
            return Result.success().setCode("200").setMsg("修改成功");
        }
        return Result.failure("0","修改失败");
    }

    @GetMapping("/allsys")
    public Result selectSys(){
        List<System> sys = sysService.selectSys();
        return Result.success().setCode("200").setMsg("查询参数成功").setData(sys);
    }
}
