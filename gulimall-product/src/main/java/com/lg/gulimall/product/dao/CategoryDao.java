package com.lg.gulimall.product.dao;

import com.lg.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-23 22:08:59
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
