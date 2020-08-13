package com.mode.springboot.exception;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/4/2 10:10
 * @Description:
 */
public class NotLoginException extends RuntimeException {

    public NotLoginException() {
        super();
    }
    public NotLoginException(String msg,Throwable cause) {
        super(msg,cause);
    }
}
