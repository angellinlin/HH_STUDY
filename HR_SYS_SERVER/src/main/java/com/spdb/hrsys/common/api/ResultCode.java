package com.spdb.hrsys.common.api;

public enum ResultCode implements Code{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
