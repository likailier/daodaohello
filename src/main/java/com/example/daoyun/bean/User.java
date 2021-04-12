package com.example.daoyun.bean;

import java.util.Date;

public class User {

    private int userId;
    private String name;
    private int sex;
    private String phone;
    private String email;
    private int age;
    private int roleId;
    private Date birthDate;
    private String school;
    private String academy;
    private String major;
    private Date creationDate;
    private String creator;
    private String modifier;
    private Date modificationDate;
    private String password;
    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", roleId=" + roleId +
                ", birthDate=" + birthDate +
                ", school='" + school + '\'' +
                ", academy='" + academy + '\'' +
                ", major='" + major + '\'' +
                ", creationDate=" + creationDate +
                ", creator='" + creator + '\'' +
                ", modifier='" + modifier + '\'' +
                ", modificationDate=" + modificationDate +
                ", password='" + password + '\'' +
                '}';
    }

    public User(int userId,String name, int sex, String phone, String email, int age, int roleId, Date birthDate, String school, String academy, String major, Date creationDate, String creator, String modifier, Date modificationDate, String password) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.roleId = roleId;
        this.birthDate = birthDate;
        this.school = school;
        this.academy = academy;
        this.major = major;
        this.creationDate = creationDate;
        this.creator = creator;
        this.modifier = modifier;
        this.modificationDate = modificationDate;
        this.password = password;
    }

    public User(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
