package com.example.daoyun.controller;

import com.example.daoyun.domain.Course;
import com.example.daoyun.service.CourseService;
import com.example.daoyun.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/allcourse")
    public Result allCourse(){
        List<Course> course = courseService.allCourse();
        return Result.success().setCode("200").setMsg("查询课程列表成功").setData(course);
    }

}
