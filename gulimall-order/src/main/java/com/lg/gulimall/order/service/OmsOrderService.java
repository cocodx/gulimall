package com.lg.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.order.entity.OmsOrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-23 23:38:39
 */
public interface OmsOrderService extends IService<OmsOrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

