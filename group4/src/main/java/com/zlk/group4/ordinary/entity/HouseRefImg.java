package com.zlk.group4.ordinary.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 房屋照片关联
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
public class HouseRefImg {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 房源id
     */
    private Integer houseId;

    /**
     * 房源照片id
     */
    private Integer houseImgId;
}