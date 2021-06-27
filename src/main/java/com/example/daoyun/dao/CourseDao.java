package com.example.daoyun.dao;

import com.example.daoyun.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {
    List<Course> allCourse();
    int checkCourse(String coursename);
    int newCourse(Course course);
}
