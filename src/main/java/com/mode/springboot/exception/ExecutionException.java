package com.mode.springboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020-01-20 14:22
 * @Description:
 */
public class ExecutionException extends RuntimeException {
    private Logger logger = LoggerFactory.getLogger(ExecutionException.class);

    private long errCode;

    private String errMsg;

    public ExecutionException(long errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
        logger.error("GRADUATE: ExecutionException, Error Code: {}>>> Message: {}", errCode, errMsg);
    }

    public ExecutionException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
        logger.error("GRADUATE: ExecutionException, Error Code: {}>>> Message: {}", errMsg);
    }

    public long getErrCode() {
        return errCode;
    }

    public void setErrCode(long errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
