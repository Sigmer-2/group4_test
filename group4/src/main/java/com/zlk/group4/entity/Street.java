package com.zlk.group4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于存储长春市全部的区域
 * @author: zhc
 * @time: 2020/9/29 11:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Street {
    /**街道id*/
    private Integer id;
    /**对应区域id*/
    private Integer areaId;
    /**街道名称*/
    private String streetName;
}
