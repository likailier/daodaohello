package com.example.daoyun.bean;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private int sex;
    private Date birthday;
    private int phone;
    private String email;
    private String identity;
    private int school_id;
    private int faculty_id;
    private int major_id;
    private String user_name;
    private String head_image;
    private int experience;
    private String extend_json;

    public User() {
    }

    public User(String name, int sex, Date birthday, int phone, String email, String identity, int school_id, int faculty_id, int major_id, String user_name, String head_image, int experience, String extend_json) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.identity = identity;
        this.school_id = school_id;
        this.faculty_id = faculty_id;
        this.major_id = major_id;
        this.user_name = user_name;
        this.head_image = head_image;
        this.experience = experience;
        this.extend_json = extend_json;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(int faculty_id) {
        this.faculty_id = faculty_id;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getExtend_json() {
        return extend_json;
    }

    public void setExtend_json(String extend_json) {
        this.extend_json = extend_json;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", school_id=" + school_id +
                ", faculty_id=" + faculty_id +
                ", major_id=" + major_id +
                ", user_name='" + user_name + '\'' +
                ", head_image='" + head_image + '\'' +
                ", experience=" + experience +
                ", extend_json='" + extend_json + '\'' +
                '}';
    }
}
