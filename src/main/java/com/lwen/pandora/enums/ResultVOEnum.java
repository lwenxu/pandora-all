package com.lwen.pandora.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResultVOEnum {
    SUCCESS(100, "success"),
    SERVICE_ERROR(101,"Service Error ... "),
    USERNAME_PASSWORD_AUTH_ERROR(102,"用户名或密码错误"),
    AUTH_EXPIRED_ERROR(103,"用户认证信息过期"),
    USER_LOCKED_ERROR(104,"用户被锁定"),
    LOGIN_ERROR(105,"用户认证失败");
    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
