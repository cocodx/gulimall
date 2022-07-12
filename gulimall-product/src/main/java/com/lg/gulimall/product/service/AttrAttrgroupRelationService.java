package com.lg.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.lg.gulimall.product.vo.AttrGroupRelationVo;

import java.util.List;
import java.util.Map;

/**
 * 属性&属性分组关联
 *
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-23 22:08:59
 */
public interface AttrAttrgroupRelationService extends IService<AttrAttrgroupRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveBatch(List<AttrGroupRelationVo> vos);
}

