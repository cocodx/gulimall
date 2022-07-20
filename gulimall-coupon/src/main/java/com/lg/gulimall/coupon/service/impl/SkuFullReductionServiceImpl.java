package com.lg.gulimall.coupon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lg.gulimall.common.to.MemberPrice;
import com.lg.gulimall.common.to.SkuReductionTo;
import com.lg.gulimall.common.utils.PageUtils;
import com.lg.gulimall.common.utils.Query;
import com.lg.gulimall.coupon.dao.SkuFullReductionDao;
import com.lg.gulimall.coupon.entity.MemberPriceEntity;
import com.lg.gulimall.coupon.entity.SkuFullReductionEntity;
import com.lg.gulimall.coupon.entity.SkuLadderEntity;
import com.lg.gulimall.coupon.service.MemberPriceService;
import com.lg.gulimall.coupon.service.SkuFullReductionService;
import com.lg.gulimall.coupon.service.SkuLadderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {

    @Autowired
    private SkuLadderService skuLadderService;

    @Autowired
    private MemberPriceService memberPriceService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo skuReductionTo) {
        //1、保存满减打折，会员价
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        skuLadderEntity.setSkuId(skuReductionTo.getSkuId());
        skuLadderEntity.setFullCount(skuReductionTo.getFullCount());
        skuLadderEntity.setDiscount(skuReductionTo.getDiscount());
        skuLadderEntity.setAddOther(skuReductionTo.getCountStatus());
        if (skuLadderEntity.getFullCount() > 0) {
            skuLadderService.save(skuLadderEntity);
        }

        SkuFullReductionEntity skuFullReductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(skuReductionTo, skuFullReductionEntity);
        if (skuFullReductionEntity.getFullPrice().compareTo(new BigDecimal("0")) == 1) {
            this.save(skuFullReductionEntity);
        }

        List<MemberPrice> memberPrices = skuReductionTo.getMemberPrices();
        List<MemberPriceEntity> memberPriceEntities = memberPrices.stream().map(item -> {
                    MemberPriceEntity memberPriceEntity = new MemberPriceEntity();
                    memberPriceEntity.setSkuId(skuReductionTo.getSkuId());
                    memberPriceEntity.setMemberLevelId(item.getId());
                    memberPriceEntity.setMemberLevelName(item.getName());
                    memberPriceEntity.setMemberPrice(item.getPrice());
                    memberPriceEntity.setAddOther(1);
                    return memberPriceEntity;
                }).filter(item -> {
                    return item.getMemberPrice().compareTo(new BigDecimal("0")) > 0;
                })
                .collect(Collectors.toList());

        memberPriceService.saveBatch(memberPriceEntities);
    }

}