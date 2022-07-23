package com.lg.gulimall.ware.feign;

import com.lg.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author amazfit
 * @date 2022-07-23 上午8:11
 **/
@FeignClient("gulimall-product")
public interface ProductFeignService {

    /**
     * 两种请求
     * <p>
     * 第一种过网关
     * gulimall-gateway
     * /api/**
     * <p>
     * 第二种直接给所在服务的机器发请求
     *
     * @param skuId
     * @return
     */
    @RequestMapping("/product/skuinfo/info/{skuId}")
    public R info(@PathVariable("skuId") Long skuId);
}
