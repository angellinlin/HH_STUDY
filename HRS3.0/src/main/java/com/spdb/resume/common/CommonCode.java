package com.spdb.resume.common;

import lombok.ToString;

@ToString
public enum  CommonCode {
    REPETID(1,"ID已存在"),
    ADDED(2,"简历增加成功"),
    DELETED(3,"简历删除成功"),
    UPDATED(4,"简历修改成功"),
    NOTFOUND(5,"未找到相关简历");

    private int code;
    private String message;

    CommonCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
