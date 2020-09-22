package com.zlk.group4.ordinary.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 房间照片
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
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