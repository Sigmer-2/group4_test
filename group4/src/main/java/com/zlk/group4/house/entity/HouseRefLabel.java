package com.zlk.group4.house.entity;

import lombok.Data;

import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
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

    @Transient
    private HouseLabel houseLabel;
}