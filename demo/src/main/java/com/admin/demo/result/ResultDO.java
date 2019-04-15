package com.admin.demo.result;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author sam199510 273045049@qq.com
 * @version Created Time:2019-04-09 22:41:36
 */
@Data
public class ResultDO<T> {

    private boolean success;

    private T data;

    private String code;

    private String errMsg;

    private int errCode;

    private int total;

    public static <T> ResultDO<T> buildSuccess(T data) {
        ResultDO resultDO = new ResultDO();
        resultDO.data = data;
        resultDO.success = true;
        resultDO.errCode = 200;
        resultDO.code="ACK";
        resultDO.setErrMsg(null);
        return resultDO;
    }

    public static <T> ResultDO<T> buildSuccess(T data, int total) {
        ResultDO resultDO = new ResultDO();
        resultDO.data = data;
        resultDO.total = total;
        resultDO.errCode = 200;
        resultDO.code="ACK";
        resultDO.errMsg = null;
        resultDO.success = true;
        return resultDO;
    }

    public static <T> ResultDO<T> buildError(String errMsg) {
        ResultDO resultDO = new ResultDO();
        resultDO.setSuccess(false);
        resultDO.setErrCode(500);
        resultDO.setErrMsg(errMsg);
        return resultDO;
    }

}
