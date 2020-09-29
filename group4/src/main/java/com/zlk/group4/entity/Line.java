package com.zlk.group4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于存储长春市全部的地铁线路
 * @author: zhc
 * @time: 2020/9/29 11:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Line {
    /**线路id*/
    private Integer id;
    /**线路名称*/
    private String lineName;

}
