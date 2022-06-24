package com.lg.gulimall.member.feign;

import com.lg.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 声明式远程调用
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {


    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
