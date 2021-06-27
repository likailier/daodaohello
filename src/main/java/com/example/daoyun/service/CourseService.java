package com.example.daoyun.service;

import com.example.daoyun.dao.CourseDao;
import com.example.daoyun.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> allCourse();
    int checkCourse(String coursename);
    int newCourse(Course course);
}
