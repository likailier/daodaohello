package com.example.daoyun.service;

import com.example.daoyun.domain.Class;
import com.example.daoyun.domain.StudentClass;
import com.example.daoyun.domain.User;

import java.util.List;

public interface ClassService {
    int newClass(Class newclass);
    int joinClass(StudentClass studentClass);
    int exitClass(StudentClass studentClass);
    int deleteClass(String classnumber);
    Class classInfo(String classnumber);
    int checkJoinClass(StudentClass studentClass);
    int checkClass(String classnumber);
    int checkState(String classnumber);
    int changeClassState(Class state);
    List<Class> tClassList(int teacherid);
    List<Class> sClassList(int student_number);
    List<Class> allClass();
    List<User> studentList(String class_number);
}
