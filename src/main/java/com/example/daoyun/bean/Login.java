package com.example.daoyun.bean;

public class Login {
    private int login_id;
    private String login_name;
    private String login_password;
    private int login_type;
    private int user_id;

    public Login() {
    }

    public Login(String login_name, String login_password, int login_type, int user_id) {
        this.login_name = login_name;
        this.login_password = login_password;
        this.login_type = login_type;
        this.user_id = user_id;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public int getLogin_type() {
        return login_type;
    }

    public void setLogin_type(int login_type) {
        this.login_type = login_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Login{" +
                "login_id=" + login_id +
                ", login_name='" + login_name + '\'' +
                ", login_password='" + login_password + '\'' +
                ", login_type=" + login_type +
                ", user_id=" + user_id +
                '}';
    }
}
