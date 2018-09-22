package com.sckoper.fastforestbackbone.utils.enums;

public enum ResultEnum {
    // 未知错误
    UNKNOWN_ERROR(0,"未知错误"),
    PARAM_ERROR(403,"参数不正确"),

    LOGIN_ERROR(403,"登陆错误，请登陆!"),
    USER_NOT_AUTHENTOCATED(401, "用户未认证"),
    UNKNOWN_USER_ERROR(400,"该用户不存在"),
    USER_HAS_EXISTED(1001, "用户已存在"),
    PASSWORD_ERROR(400,"密码错误"),

    ARTICLE_IS_DELETE(400,"文章可能已经被删除"),
    ROLE_ERROR(500,"权限不足"),
    CATEGORY_IS_EXIT(403,"该分类依据存在"),
    IMG_NOT_EMPTY(403,"文件不能为空"),
    IMG_FORMAT_ERROR(403,"图片格式错误"),
    SAVE_IMG_ERROE(403,"保存图片出错");

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
