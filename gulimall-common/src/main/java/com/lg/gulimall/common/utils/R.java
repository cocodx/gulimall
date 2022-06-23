package com.lg.gulimall.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author amazfit
 * @date 2022-06-23 下午9:12
 **/
public class R extends HashMap<String,Object> {

    public R() {
        put("code",0);
        put("msg","success");
    }

    public static R error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,"未知异常，请联系管理员");
    }

    public static R error(String msg){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }

    public static R error(int code,String msg){
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
    public  Integer getCode() {

        return (Integer) this.get("code");
    }
}
