package com.lg.gulimall.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author amazfit
 * @date 2022-07-17 上午3:25
 **/
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;
}
