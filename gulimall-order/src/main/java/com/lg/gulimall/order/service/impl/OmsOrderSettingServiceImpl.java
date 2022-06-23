package com.lg.gulimall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.common.utils.Query;

import com.lg.gulimall.order.dao.OmsOrderSettingDao;
import com.lg.gulimall.order.entity.OmsOrderSettingEntity;
import com.lg.gulimall.order.service.OmsOrderSettingService;


@Service("omsOrderSettingService")
public class OmsOrderSettingServiceImpl extends ServiceImpl<OmsOrderSettingDao, OmsOrderSettingEntity> implements OmsOrderSettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsOrderSettingEntity> page = this.page(
                new Query<OmsOrderSettingEntity>().getPage(params),
                new QueryWrapper<OmsOrderSettingEntity>()
        );

        return new PageUtils(page);
    }

}