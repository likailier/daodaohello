package com.example.daoyun.domain;

import java.util.Date;

public class User{
    private int number;
    private String name;
    private int sex;
    private String phone;
    private String email;
    private Date birthday;
    private String school;
    private String college;
    private String major;
    private int role;

    public User() {
    }

    public User(int number, String name, int sex, String phone, String email, Date birthday, String school, String college, String major, int role) {
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birthday = birthday;
        this.school = school;
        this.college = college;
        this.major = major;
        this.role = role;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", school='" + school + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", role=" + role +
                '}';
    }
}
