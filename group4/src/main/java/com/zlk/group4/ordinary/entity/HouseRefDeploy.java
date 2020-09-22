package com.zlk.group4.ordinary.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 房源配置关联
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
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
}