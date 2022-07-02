package com.lg.gulimall.minio.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author amazfit
 * @date 2022-07-02 下午5:33
 * minio 属性配置
 **/
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

//    @Value("endPoint")
    private String endPoint;

//    @Value("accessKey")
    private String accessKey;

//    @Value("secretKey")
    private String secretKey;


}
