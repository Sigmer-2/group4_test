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