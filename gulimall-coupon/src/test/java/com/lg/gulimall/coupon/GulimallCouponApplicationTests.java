package com.lg.gulimall.coupon;

import com.lg.gulimall.coupon.entity.CouponEntity;
import com.lg.gulimall.coupon.service.CouponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author amazfit
 * @date 2022-06-23 下午11:10
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallCouponApplicationTests {

    @Autowired
    CouponService couponService;

    @Test
    public void context(){
        CouponEntity coupon = new CouponEntity();
        coupon.setCouponName("优惠券");
        couponService.save(coupon);
    }
}
