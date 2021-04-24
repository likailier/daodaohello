package com.example.daoyun.domain;

public class Login {
    private int id;
    private int user_number;
    private String phone;
    private String email;
    private String password;
    private int role;

    public Login() {
    }

    public Login(int user_number, String phone, String email, String password, int role) {
        this.user_number = user_number;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUser_number() {
        return user_number;
    }

    public void setUser_number(int user_number) {
        this.user_number = user_number;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", user_number='" + user_number + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
