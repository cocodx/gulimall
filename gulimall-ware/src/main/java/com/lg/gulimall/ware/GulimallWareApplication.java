package com.lg.gulimall.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author amazfit
 * @date 2022-06-23 下午11:22
 **/
@SpringBootApplication
@MapperScan("com.lg.gulimall.ware.dao")
@EnableDiscoveryClient
public class GulimallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallWareApplication.class,args);
    }
}

