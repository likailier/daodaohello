package com.example.daoyun.util;

public enum ResultCodeEnum {
    OK("200", "处理成功"),
    ERROR("400","未知错误"),
    Login("100","登陆成功"),
    Register("101","注册成功"),
    LoginError("105","登陆失败"),
    RegisterError("106",""),
    TokenError("-1","令牌验证失败");


    private String code;
    private String msg;

    ResultCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
