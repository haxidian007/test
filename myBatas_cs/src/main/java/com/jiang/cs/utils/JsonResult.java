package com.jiang.cs.utils;

/**
 * 响应JSON格式的结果给前端的类
 * T 为范型
 */
public class JsonResult<T> {
    private Integer state;//状态
    private String message;//状态的描述
    private T data;//携带的数据
    public static final int SUCCESS=1;
    public static final int ERROR=0;
    public JsonResult() {
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
