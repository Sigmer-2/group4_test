package com.zlk.group4.house.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Data
public class Metro {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 地铁线路名
     */
    private String metroLine;

    /**
     * 地铁站名
     */
    private String station;
}