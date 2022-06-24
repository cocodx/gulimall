package com.lg.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author amazfit
 * @date 2022-06-23 下午11:58
 * 1、openfeign
 * 2、编写一个接口，springcloud需要调用远程服务
 **/
@SpringBootApplication
@MapperScan("com.lg.gulimall.member.dao")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.lg.gulimall.member.feign")
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class,args);
    }
}
