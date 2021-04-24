package com.example.daoyun.util;

import java.io.Serializable;
import java.util.Collections;

public class Result<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public String getCode() {
        return code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }



    public static <T> Result<T> success() {
        return Result.success(null);
    }

    public static Result failure(ResultCodeEnum resultCodeEnum) {
        return new Result()
                .setCode(resultCodeEnum.getCode())
                .setMsg(resultCodeEnum.getMsg());
    }

    public static <T> Result<T> success(T obj) {
        return new Result()
                //为null统一给前端{}
                .setData(obj == null ? Collections.EMPTY_MAP : obj)
                .setCode(ResultCodeEnum.OK.getCode())
                .setMsg(ResultCodeEnum.OK.getMsg());
    }
}
