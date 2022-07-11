package com.lg.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.product.entity.AttrEntity;
import com.lg.gulimall.product.vo.AttrGroupRelationVo;
import com.lg.gulimall.product.vo.AttrRespVo;
import com.lg.gulimall.product.vo.AttrVo;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-23 22:08:59
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveAttr(AttrVo attr);

    PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    /**
     * 根据分组id，查找关联的所有属性，基本属性
     *
     * @param attrGroupId
     * @return
     */
    List<AttrEntity> getRelationAttr(Long attrGroupId);

    void deleteRelation(AttrGroupRelationVo[] attrGroupRelationVo);

    /**
     * 获取当前分组没有关联的所有属性
     *
     * @param params
     * @param attrGroupId
     * @return
     */
    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrGroupId);
}

