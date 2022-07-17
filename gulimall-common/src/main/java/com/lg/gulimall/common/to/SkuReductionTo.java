package com.lg.gulimall.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 这是满减
 *
 * @author amazfit
 * @date 2022-07-17 下午4:37
 **/
@Data
public class SkuReductionTo {

    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrices;
}
