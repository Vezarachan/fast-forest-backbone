package com.sckoper.fastforestbackbone.utils;

import com.sckoper.fastforestbackbone.utils.enums.ResultEnum;
import lombok.Data;

@Data
public class ResponseMessage {

    /**
     * 响应代码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;

    public ResponseMessage() {}

    public ResponseMessage(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseMessage(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }
}
