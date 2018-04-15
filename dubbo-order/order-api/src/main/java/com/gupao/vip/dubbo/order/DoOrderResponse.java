package com.gupao.vip.dubbo.order;

import java.io.Serializable;

public class DoOrderResponse implements Serializable{

    private static final long serialVersionUID = -6151645655426306681L;
    private Object date;

    private String code;

    private String memo;

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "DoOrderResponse{" +
                "date=" + date +
                ", code='" + code + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
