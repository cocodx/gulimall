package com.lg.gulimall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.common.utils.Query;

import com.lg.gulimall.order.dao.OmsOrderDao;
import com.lg.gulimall.order.entity.OmsOrderEntity;
import com.lg.gulimall.order.service.OmsOrderService;


@Service("omsOrderService")
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderDao, OmsOrderEntity> implements OmsOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderEntity> page = this.page(
                new Query<OmsOrderEntity>().getPage(params),
                new QueryWrapper<OmsOrderEntity>()
        );

        return new PageUtils(page);
    }

}