package com.yan.user.Entity;

import java.util.HashSet;

/**
 * Created by yanwenbo on 2017-09-21.
 */
public enum StatusEnum {
    SUCCESS("0000","登录成功"),
    FAILURE("1000","登录失败，不存在该用户"),
    PSSWORD_WORNG("2000","密码错误"),
    BAD_REQUEST("3000","错误的请求");

    private final String code;
    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private StatusEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    private static HashSet<String> hashSet;
    static {
        hashSet = new HashSet<String>();
        for (StatusEnum statusEnum:StatusEnum.values()) {
            hashSet.add(statusEnum.getCode());
        }
    }
}
