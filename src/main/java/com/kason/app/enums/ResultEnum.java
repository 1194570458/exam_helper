package com.kason.app.enums;

public enum ResultEnum {
    MANAGER_LOGIN_ERROR(1,"账号密码不正确"),
    MANAGER_USERNAME_NULL(2,"用户名不能为空"),
    MANAGER_PASSWORD_NULL(3,"密码不能为空"),
    CERTIFICATE_NULL(4,"没有此证书ID"),
    CERTIFICATE_NAME_NULL(5,"证书名不能为空"),
    CERTIFICATE_ID_NULL(6,"证书ID不能为空"),
    CERTIFICATE_EXIST(7,"证书名已经存在"),
    CERTIFICATE_ISUSEING(17,"证书名还被使用中"),
    EXAM_EXIST(8,"软考类型已经存在"),
    EXAM_NULL(9,"软考类型信息不存在"),
    EXAM_ID_NULL(10,"软考ID不能为空"),
    EXAM_NAME_NULL(11,"软考类型不能为空"),
    MEMBER_PHONE_EXIST(12,"该手机号已被注册"),
    MEMBER_ERROR(13,"账号或者密码不正确"),
    PHONE_ERROR(14,"手机号码格式错误"),
    MEMBER_PHONE_NULL(15,"手机号码不能为空"),
    MEMBER_PASSWORD_NULL(16,"用户密码不能为空"),

    VERTIFY_ERROR(99,"登陆过期")
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
