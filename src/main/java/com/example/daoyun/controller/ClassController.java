package com.example.daoyun.controller;

import com.example.daoyun.domain.Class;
import com.example.daoyun.domain.StudentClass;
import com.example.daoyun.domain.User;
import com.example.daoyun.service.ClassService;
import com.example.daoyun.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    ClassService classService;

    @PostMapping("/newclass")
    public Result newClass(@RequestBody Class newclass){
        String classnumber = String.valueOf((int)(Math.random()*90000000+10000000));
        newclass.setClassnumber(classnumber);
        if (classService.newClass(newclass) == 1){
            return Result.success().setCode("200").setMsg("创建班课成功").setData(classnumber);
        }
        return Result.failure("0","创建班课失败");
    }

    @PostMapping("/joinclass")
    public Result joinClass(@RequestBody StudentClass studentClass){
        if (classService.checkClass(studentClass.getClass_number()) == 0){
            return Result.failure("0","班课不存在");
        }
        int classstate = classService.checkState(studentClass.getClass_number());
        if (classstate == 2){
            return Result.failure("0","班课已不允许加入");
        }
        if (classstate == 3){
            return Result.failure("0","班课已关闭");
        }
        if (classService.checkJoinClass(studentClass) == 1){
            return Result.failure("0","您已加入该班课，请勿重复加入");
        }
        if (classService.joinClass(studentClass) == 1){
            return Result.success().setCode("200").setMsg("加入班课成功");
        }
        return Result.failure("0","加入班课失败");
    }

    @DeleteMapping("/exitclass")
    public Result exitClass(@RequestBody StudentClass studentClass){
        if (classService.exitClass(studentClass) == 1){
            return Result.success().setCode("200").setMsg("退出班课成功");
        }
        return Result.failure("0","退出班课失败");
    }

    @DeleteMapping("/deleteclass/{classnumber}")
    public Result deleteClass(@PathVariable String classnumber){
        if (classService.deleteClass(classnumber) == 1){
            return Result.success().setCode("200").setMsg("删除成功");
        }
        return Result.failure("0","无法删除存在学生的班课");
    }

    @GetMapping("/tclasslist/{teacherid}")
    public Result tClassList(@PathVariable int teacherid){
        List<Class> tclass = classService.tClassList(teacherid);
        return Result.success().setCode("200").setMsg("查询教师班课成功").setData(tclass);
    }

    @GetMapping("/sclasslist/{student_number}")
    public Result sClassList(@PathVariable int student_number){
        if(student_number == 0 ){
            return Result.failure("0","请补充学号信息");
        }
        List<Class> sclass = classService.sClassList(student_number);
        return Result.success().setCode("200").setMsg("查询学生班课成功").setData(sclass);
    }

    @GetMapping("/allclass")
    public Result allClass(){
        List<Class> classlist = classService.allClass();
        return Result.success().setCode("200").setMsg("查看班课列表成功").setData(classlist);
    }

    @GetMapping("/classinfo/{classnumber}")
    public Result classInfo(@PathVariable String classnumber){
        return Result.success().setCode("200").setMsg("查询班课信息成功").setData(classService.classInfo(classnumber));
    }

    @PutMapping("/changeclassstate")
    public Result changeClassState(@RequestBody Class state){
        if (classService.changeClassState(state) == 1){
            return Result.success().setCode("200").setMsg("修改成功");
        }
        return Result.failure("0","修改失败");
    }

    @GetMapping("/studentlist/{class_number}")
    public Result studentList(@PathVariable String class_number){
        List<User> studentlist = classService.studentList(class_number);
        return Result.success().setCode("200").setMsg("查看班课列表成功").setData(studentlist);
    }
}
