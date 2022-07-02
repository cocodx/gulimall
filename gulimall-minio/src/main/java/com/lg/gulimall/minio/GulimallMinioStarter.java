package com.lg.gulimall.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author amazfit
 * @date 2022-07-02 下午5:06
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class   GulimallMinioStarter {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMinioStarter.class,args);
    }
}
