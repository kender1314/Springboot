package com.mode.springboot.common;

/**
 * @Author hejiang
 * @Version 1.0.0 RELEASE
 * @Date 2020/4/2 10:10
 * @Description: 统一结果返回
 */
public class Result<T> {
    /**
     * 错误代码（可以设定例如500表示错误）
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 数据内容
     */
    private T data;

    /**
     * 时间戳
     */
    private Long time = System.currentTimeMillis();


    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", time=" + time +
                '}';
    }
}
