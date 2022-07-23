package com.lg.gulimall.ware.vo;

import lombok.Data;

/**
 * @author amazfit
 * @date 2022-07-23 上午7:40
 **/
@Data
public class PurchaseItemDoneVo {

    private Long itemId;
    private Integer status;
    private String reason;
}
