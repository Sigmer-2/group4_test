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
public class Region {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 区名
     */
    private String distrctName;

    /**
     * 街道名
     */
    private String street;
}