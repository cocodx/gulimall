package com.lg.gulimall.product.feign;

import com.lg.gulimall.common.to.SkuReductionTo;
import com.lg.gulimall.common.to.SpuBoundTo;
import com.lg.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    /**
     * 1.将对象转为json
     * 2,springcloud给远程服务，给/coupon/spubounds/save发送请求。将上一步转的json对象放在请求体位置，发送请求
     * 3，对方服务收到请求。请求体里有json数据。将请求体的json转为spuBoundsEntity【只要属性名一致就可以一一封装】
     * 只要json数据模型是兼容的。双方服务无需使用同一个to
     *
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
