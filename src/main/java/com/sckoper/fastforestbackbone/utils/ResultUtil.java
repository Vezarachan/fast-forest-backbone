package com.sckoper.fastforestbackbone.utils;

import com.sckoper.fastforestbackbone.utils.enums.ResultEnum;

public class ResultUtil {

    public static ResponseMessage success(Object object) {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setCode(200);
        responseMessage.setMsg("请求成功");
        responseMessage.setData(object);
        return responseMessage;
    }

    public static ResponseMessage success() {
        return ResultUtil.success(null);
    }

    public static ResponseMessage error(Integer code, String msg) {
        return new ResponseMessage(code, msg);
    }

    public static ResponseMessage error(ResultEnum resultEnum) {
        return new ResponseMessage(resultEnum);
    }
}
