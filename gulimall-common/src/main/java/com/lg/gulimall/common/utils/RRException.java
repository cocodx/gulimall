package com.lg.gulimall.common.utils;

import lombok.Data;

/**
 * @author amazfit
 * @date 2022-06-23 下午9:48
 **/
@Data
public class RRException extends RuntimeException{

    private String msg;
    private int code=500;

    public RRException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public RRException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public RRException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public RRException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
