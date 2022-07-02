package com.lg.gulimall.product.exception;

import com.lg.gulimall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author amazfit
 * @date 2022-07-02 下午11:51
 **/
@Slf4j
@RestControllerAdvice(basePackages = "com.lg.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {


    @ExceptionHandler(value = Exception.class)
    public R handleValidException(Exception e){
        log.error("数据校验出现问题:{},异常类型:{}",e.getMessage(),e.getClass());
        return R.error();
    }
}
