package com.example.daoyun.service.impl;

import com.example.daoyun.dao.ClassDao;
import com.example.daoyun.dao.CourseDao;
import com.example.daoyun.domain.Class;
import com.example.daoyun.domain.Course;
import com.example.daoyun.domain.StudentClass;
import com.example.daoyun.domain.User;
import com.example.daoyun.service.ClassService;
import com.example.daoyun.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDao classDao;

    @Override
    public int newClass(Class newclass) {
        newclass.setState(1);
        return classDao.newClass(newclass);
    }

    @Override
    public int joinClass(StudentClass studentClass) {
        studentClass.setClass_exp(0);
        return classDao.joinClass(studentClass);
    }

    @Override
    public int exitClass(StudentClass studentClass) {
        return classDao.exitClass(studentClass);
    }

    @Override
    public int deleteClass(String classnumber) {
        if (classDao.checkStudentClass(classnumber) > 0){
            return 0;
        }
        return classDao.deleteClass(classnumber);
    }

    @Override
    public Class classInfo(String classnumber) {
        return classDao.classInfo(classnumber);
    }

    @Override
    public int checkJoinClass(StudentClass studentClass) {
        return classDao.checkJoinClass(studentClass);
    }

    @Override
    public int checkClass(String classnumber) {
        return classDao.checkClass(classnumber);
    }

    @Override
    public int checkState(String classnumber) {
        return classDao.checkState(classnumber);
    }

    @Override
    public int changeClassState(Class state) {
        return classDao.changeClassState(state);
    }

    @Override
    public List<Class> tClassList(int teacherid) {
        return classDao.tClassList(teacherid);
    }

    @Override
    public List<Class> sClassList(int student_number) {
        return classDao.sClassList(student_number);
    }

    @Override
    public List<Class> allClass() {
        return classDao.allClass();
    }

    @Override
    public List<User> studentList(String class_number) {
        return classDao.studentList(class_number);
    }
}
