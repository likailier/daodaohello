package com.example.daoyun.controller;

import com.example.daoyun.domain.Ssign;
import com.example.daoyun.domain.System;
import com.example.daoyun.domain.Tsign;
import com.example.daoyun.domain.User;
import com.example.daoyun.service.SignService;
import com.example.daoyun.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SignController {

    @Autowired
    SignService signService;

    @PostMapping("/teachersign")
    public Result teacherSign(@RequestBody Tsign tsign){
        if (signService.checkSign(tsign) > 0){
            return Result.failure("0","当前班课已存在签到");
        }
        if (signService.teacherSign(tsign) == 1){
            return Result.success().setCode("200").setMsg("发布签到成功");
        }

        return Result.failure("0","发布签到失败");
    }

    @PostMapping("/studentsign")
    public Result studentSign(@RequestBody Ssign ssign){
        Tsign tsign = new Tsign();
        tsign.setClassnumber(ssign.getClassnumber());
        if (signService.checkSign(tsign) == 2){
            return Result.failure("0","请勿重复签到");
        }
        if (signService.checkSign(tsign) == 0){
            return Result.failure("0","当前班课不存在签到");
        }
        if (signService.studentSign(ssign) == 1){
            return Result.success().setCode("200").setMsg("签到成功");
        }

        return Result.failure("0","请勿重复签到");
    }

    @PutMapping("/finishsign/{tsignid}")
    public Result finishSign(@PathVariable int tsignid){
        if (signService.finishSign(tsignid) == 1){
            return Result.success().setCode("200").setMsg("结束签到");
        }

        return Result.failure("0","结束签到失败");
    }

    @GetMapping("/classsignlist/{classnumber}")
    public Result classSignList(@PathVariable String classnumber){
        List<Tsign> classTsign = signService.classSignList(classnumber);
        return Result.success().setCode("200").setMsg("查询签到记录成功").setData(classTsign);
    }

    @GetMapping("/studentsignlist/{tsignid}")
    public Result studentSignList(@PathVariable int tsignid){
        List<Ssign> studentSignList = signService.studentSignList(tsignid);
        Map result = new HashMap();
        result.put("number",studentSignList.size());
        result.put("studentSignList",studentSignList);
        return Result.success().setCode("200").setMsg("签到学生").setData(result);
    }

    @GetMapping("/nosignlist")
    public Result noSignList(@RequestBody Tsign tsign){
        List<User> nosignlist = signService.noSignList(tsign);
        return Result.success().setCode("200").setMsg("未签到学生").setData(nosignlist);
    }

    @PostMapping("/susign")
    public Result suSign(@RequestBody Ssign ssign){
        if (signService.suSign(ssign) == 1){
            return Result.success().setCode("200").setMsg("补签成功");
        }
        return Result.failure("0","补签失败");
    }


}
