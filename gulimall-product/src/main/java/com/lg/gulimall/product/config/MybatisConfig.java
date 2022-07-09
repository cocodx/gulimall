package com.lg.gulimall.product.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author amazfit
 * @date 2022-07-09 下午11:13
 **/
@Configuration
//开启事务
@EnableTransactionManagement
@MapperScan("com.lg.gulimall.product.dao")
public class MybatisConfig {

    //引入分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor interceptor = new PaginationInterceptor();
        //设置请求的界面大于最大页后操作，true调回首页，false继续请求，默认false
        interceptor.setOverflow(true);
//        设置最大单页限制数量，默认500条，-1不受限制
        interceptor.setLimit(1000);
        return interceptor;
    }
}
