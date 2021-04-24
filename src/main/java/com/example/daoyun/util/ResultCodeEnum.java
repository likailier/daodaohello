package com.example.daoyun.util;

public enum ResultCodeEnum {
    OK("200", "处理成功"),
    Login("100","登陆成功"),
    LoginError("105","登陆失败"),
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
