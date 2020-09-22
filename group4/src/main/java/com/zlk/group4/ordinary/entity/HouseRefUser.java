package com.zlk.group4.ordinary.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:房屋用户关联
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
public class HouseRefUser {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 房源id
     */
    private Integer houseId;
}