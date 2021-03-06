package com.lg.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lg.gulimall.product.entity.CategoryEntity;
import com.lg.gulimall.product.service.CategoryService;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.common.utils.R;



/**
 * 商品三级分类
 *
 * @author liugang
 * @email 2cevening@gmail.com
 * @date 2022-06-23 22:08:59
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有分类以及子分类，以树形结构组装起来
     * @return
     */
    @RequestMapping("/list/tree")
    public R listTree(){
        List<CategoryEntity> entities = categoryService.listWithTree();
        return R.ok().put("data",entities);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    @RequestMapping("/update/sort")
    public R updateSort(@RequestBody CategoryEntity[] categories){
        categoryService.updateBatchById(Arrays.asList(categories));
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateCascade(category);
        return R.ok();
    }

    /**
     * 删除
     * springmvc自动把请求体的数据json，转为对象的对象
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
		categoryService.removeMenuByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
