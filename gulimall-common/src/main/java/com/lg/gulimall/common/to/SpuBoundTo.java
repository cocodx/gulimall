package com.lg.gulimall.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author amazfit
 * @date 2022-07-17 下午4:27
 **/
@Data
public class SpuBoundTo {

    private Long spuId;

    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
