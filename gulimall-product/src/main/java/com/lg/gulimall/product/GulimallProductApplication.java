package com.lg.gulimall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author amazfit
 * @date 2022-06-23 下午10:37
 **/
@SpringBootApplication
@MapperScan("com.lg.gulimall.product.dao")
@EnableDiscoveryClient//开启服务注册与发现
public class GulimallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class,args);
    }
}
