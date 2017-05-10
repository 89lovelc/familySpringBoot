package com.hjh.cn.po;

import java.io.Serializable;

/**
 * Created by 89lovelc on 2017/5/5.
 */
public class Message implements Serializable {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
