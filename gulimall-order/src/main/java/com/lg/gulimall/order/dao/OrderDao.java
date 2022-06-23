package com.lg.gulimall.order.dao;

import com.lg.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-23 23:52:06
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
