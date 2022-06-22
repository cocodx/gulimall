package com.lg.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lg.common.utils.PageUtils;
import com.lg.gulimall.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-22 02:10:04
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
