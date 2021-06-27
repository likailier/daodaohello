package com.example.daoyun.service.impl;

import com.example.daoyun.dao.CourseDao;
import com.example.daoyun.domain.Course;
import com.example.daoyun.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> allCourse() {
        return courseDao.allCourse();
    }

    @Override
    public int checkCourse(String coursename) {
        return courseDao.checkCourse(coursename);
    }

    @Override
    public int newCourse(Course course) {
        return newCourse(course);
    }
}
