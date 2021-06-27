package com.example.daoyun.domain;

public class StudentClass {
    private int studentclass_id;
    private int student_number;
    private String class_number;
    private int class_exp;

    public int getStudentclass_id() {
        return studentclass_id;
    }

    public void setStudentclass_id(int studentclass_id) {
        this.studentclass_id = studentclass_id;
    }

    public int getStudent_number() {
        return student_number;
    }

    public void setStudent_number(int student_number) {
        this.student_number = student_number;
    }

    public String getClass_number() {
        return class_number;
    }

    public void setClass_number(String class_number) {
        this.class_number = class_number;
    }

    public int getClass_exp() {
        return class_exp;
    }

    public void setClass_exp(int class_exp) {
        this.class_exp = class_exp;
    }
}
