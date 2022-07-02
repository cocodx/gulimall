package com.lg.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.common.utils.Query;

import com.lg.gulimall.product.dao.BrandDao;
import com.lg.gulimall.product.entity.BrandEntity;
import com.lg.gulimall.product.service.BrandService;
import org.springframework.util.StringUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<BrandEntity> brandEntityQueryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(params.get("key"))){
            brandEntityQueryWrapper.like("name",params.get("key"));
        }
        IPage<BrandEntity> page = this.page(new Query<BrandEntity>().getPage(params), brandEntityQueryWrapper);

        return new PageUtils(page);
    }

}