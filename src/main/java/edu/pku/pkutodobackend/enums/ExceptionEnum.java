package edu.pku.pkutodobackend.enums;

/**
 * @Author：liudawei
 * @Description: Service层处结果的异常类
 * @DateTime:2024/10/6 19:39
 **/
public enum ExceptionEnum {
    USERNAME_OR_PASSWORD_ERROR(10001, "用户名或密码错误"),
    USERNAME_EXIST(10002, "用名名已存在"),
    USER_EMAIL_ERROR(10003, "邮箱错误"),
    USER_EMAIL_EXIST(10004, "邮箱已注册"),
    USER_CODE_ERROR(10005, "验证码错误"),
    USER_CODE_NOT_EXIST(10006, "验证码过期或不存在"),
    ERROR(-1, "未知错误"),
    SUCCESS(0, "ok");

    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    public static ExceptionEnum getValue(Integer code) {
        for (ExceptionEnum e : values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return ExceptionEnum.ERROR;
    }
}
