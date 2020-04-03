package com.example.enums;

/**
 * 错误码
 */
public enum ErrorCodeEnum {

    FAIL(198, "请求处理失败"),
    NONE(0, "无异常"),
    UNAUTHORIZED(401, "未授权");


    private int code;

    private String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 通过错误码获取枚举项
     *
     * @param code
     * @return
     */
    public static ErrorCodeEnum getByCode(int code) {
        for (ErrorCodeEnum item : ErrorCodeEnum.values()) {
            if (item.getCode() == code) {
                return item;
            }
        }
        return NONE;
    }

}
