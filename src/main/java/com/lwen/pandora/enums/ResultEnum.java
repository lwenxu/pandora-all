package com.lwen.pandora.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(100, "success"),
    SERVICE_ERROR(100,"Service Error ... ");
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
