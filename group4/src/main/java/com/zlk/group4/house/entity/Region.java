package com.zlk.group4.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:区域
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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