package com.lg.gulimall.product.vo;

import com.lg.gulimall.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

/**
 * @author amazfit
 * @date 2022-07-13 上午7:18
 **/
@Data
public class AttrGroupWithAttrVo {

    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;

    private List<AttrEntity> attrs;
}
