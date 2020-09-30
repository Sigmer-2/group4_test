package com.zlk.group4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于存储长春市全部的地铁站点
 * @author: zhc
 * @time: 2020/9/29 11:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    /**站点id*/
    private Integer id;
    /**对应线路id*/
    private Integer lineId;
    /**站点名称*/
    private String stationName;
}
