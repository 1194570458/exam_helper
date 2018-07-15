package com.kason.app.enums;

public enum ResultEnum {

    USER_ERROR(1,"账号或者密码错误"),
    USER_EXIST(2,"用户已经存在"),
    USER_TOKEN_ERROR(3,"token验证失败"),
    CERTIFICATE_EXIST(4,"证书已经存在"),
    CERTIFICATE_NOT_EXIST(5,"证书不存在"),
    USER_NOT_EXIST(6,"用户不存在"),


    VERTIFY_ERROR(99,"请登陆后操作")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
