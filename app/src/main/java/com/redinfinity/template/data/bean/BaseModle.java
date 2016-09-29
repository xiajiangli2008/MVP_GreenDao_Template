package com.redinfinity.template.data.bean;

/**
 * 项目名称：
 * 类描述：
 * 创建人：Administrator
 * 创建时间：2016/8/8 15:16
 * 修改人：Administrator
 * 修改时间：2016/8/8 15:16
 * 修改备注：
 */
public class BaseModle<T> {
    /**
     * status : true
     * errcode : 0
     * message : success
     * data : {}
     */

    private boolean status;
    private int errcode;
    private String message;
    private T data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
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

    @Override
    public String toString() {
        return "BaseModle{" +
                "status=" + status +
                ", errcode=" + errcode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
