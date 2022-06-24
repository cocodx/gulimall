package com.lg.gulimall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author amazfit
 * @date 2022-06-23 下午11:42
 **/
@SpringBootApplication
@MapperScan("com.lg.gulimall.order.dao")
@EnableDiscoveryClient
public class GulimallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallOrderApplication.class,args);
    }
}
