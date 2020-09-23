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
public class HouseImg {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     * 是否为封面（0：不是，1：是）
     */
    private Integer imgPage;
}