package com.lg.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lg.gulimall.product.entity.BrandEntity;
import com.lg.gulimall.product.service.BrandService;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.common.utils.R;



/**
 * 品牌
 *
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-23 22:08:59
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BrandEntity brand){
		brandService.save(brand);

        return R.ok();
    }

    @RequestMapping("/update/status")
    public R updateStatus(@RequestBody BrandEntity brand){
        UpdateWrapper<BrandEntity> brandWrapper = new UpdateWrapper<>();
        brandWrapper.set("brand_id",brand.getBrandId());
        brandWrapper.set("show_status",brand.getShowStatus());
        brandService.update(brandWrapper);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BrandEntity brand){
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("brand_id",brand.getBrandId());
        updateWrapper.set("show_status",brand.getShowStatus());
		brandService.update(null,updateWrapper);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
