package com.example.daoyun.dao;

import com.example.daoyun.domain.Class;
import com.example.daoyun.domain.StudentClass;
import com.example.daoyun.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao {
    int newClass(Class newclass);
    int joinClass(StudentClass studentClass);
    int exitClass(StudentClass studentClass);//学生退出班课
    int deleteClass(String classnumber);//老师删除班课
    Class classInfo(String classnumber);
    int checkJoinClass(StudentClass studentClass);
    int checkClass(String classnumber);
    int checkState(String classnumber);
    int changeClassState(Class state);
    int checkStudentClass(String class_number);//查看某个班课的人数
    List<Class> tClassList(int teacherid);
    List<Class> sClassList(int student_number);
    List<Class> allClass();
    List<User> studentList(String class_number);
}
