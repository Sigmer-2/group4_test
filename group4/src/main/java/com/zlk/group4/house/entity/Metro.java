package com.zlk.group4.house.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:地铁
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
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
    private String street;
}