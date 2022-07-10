package com.lg.gulimall.product.vo;

import lombok.Data;

/**
 * @author amazfit
 * @date 2022-07-10 下午5:10
 **/
@Data
public class AttrRespVo extends AttrVo{

    /**
     * 所属分类名字：手机/数码/手机
     */
    private String catelogName;

    /**
     * 所属分组名字：主体，所属分组名字
     */
    private String groupName;

    private Long[] catelogPath;
}
