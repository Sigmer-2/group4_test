package com.zlk.group4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于存储长春市全部的区域
 * @author: zhc
 * @time: 2020/9/29 11:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    /**区域id*/
    private Integer id;
    /**区域名称*/
    private String areaName;

}
