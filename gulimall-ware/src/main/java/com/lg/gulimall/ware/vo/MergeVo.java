package com.lg.gulimall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author amazfit
 * @date 2022-07-21 上午3:24
 **/
@Data
public class MergeVo {

    private Long purchaseId;
    private List<Long> items;
}
