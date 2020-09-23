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
public class HouseRefDeploy {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 房源id
     */
    private Integer houseId;

    /**
     * 配置id
     */
    private Integer houseDeployId;

    @Transient
    private HouseDeploy houseDeploy;
}