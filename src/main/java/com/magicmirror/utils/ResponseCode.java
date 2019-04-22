package com.magicmirror.utils;

public enum ResponseCode {

    SUCCESS(200, "SUCCESS"),
    NOTFOUND(404, "NOTFOUND"),
    SERVERERROR(500, "SERVERERROR");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
