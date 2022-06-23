package com.lg.gulimall.ware;

import com.lg.gulimall.ware.entity.WareInfoEntity;
import com.lg.gulimall.ware.service.WareInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author amazfit
 * @date 2022-06-23 下午11:23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallWareApplicationTest {

    @Autowired
    WareInfoService wareInfoService;

    @Test
    public void context(){
        WareInfoEntity wareInfoEntity = new WareInfoEntity();
        wareInfoEntity.setName("G2");
        wareInfoService.save(wareInfoEntity);
    }
}
