package com.zlk.group4.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description: 房源配置关联
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    /**
     * 注入房间配置表
     * */
    private HouseDeploy houseDeploy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getHouseDeployId() {
        return houseDeployId;
    }

    public void setHouseDeployId(Integer houseDeployId) {
        this.houseDeployId = houseDeployId;
    }
}