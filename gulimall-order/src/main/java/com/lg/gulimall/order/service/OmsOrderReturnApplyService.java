package com.lg.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.order.entity.OmsOrderReturnApplyEntity;

import java.util.Map;

/**
 * 订单退货申请
 *
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-23 23:38:39
 */
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

