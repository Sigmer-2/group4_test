package com.zlk.group4.ordinary.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 房屋标签关联
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
public class HouseRefLabel {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 房源id
     */
    private Integer houseId;

    /**
     * 标签id
     */
    private Integer houseLabelId;
}