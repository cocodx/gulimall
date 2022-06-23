package com.lg.gulimall.order;

import com.lg.gulimall.order.entity.OmsOrderEntity;
import com.lg.gulimall.order.service.OmsOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author amazfit
 * @date 2022-06-23 下午11:45
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallOrderApplicationTests {


    @Autowired
    OmsOrderService omsOrderService;

    @Test
    public void contextLoads(){
        OmsOrderEntity omsOrderEntity = new OmsOrderEntity();
        omsOrderEntity.setBillContent("老外不吃内脏？");
        omsOrderService.save(omsOrderEntity);
    }
}
