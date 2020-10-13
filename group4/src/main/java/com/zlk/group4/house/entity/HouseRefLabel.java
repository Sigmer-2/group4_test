package com.zlk.group4.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description: 房屋标签关联
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    /**
     * 注入房源标签表
     * */
    private HouseLabel houseLabel;

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

    public Integer getHouseLabelId() {
        return houseLabelId;
    }

    public void setHouseLabelId(Integer houseLabelId) {
        this.houseLabelId = houseLabelId;
    }

    public HouseLabel getHouseLabel() {
        return houseLabel;
    }

    public void setHouseLabel(HouseLabel houseLabel) {
        this.houseLabel = houseLabel;
    }

    @Override
    public String toString() {
        return "HouseRefLabel{" +
                "id=" + id +
                ", houseId=" + houseId +
                ", houseLabelId=" + houseLabelId +
                ", houseLabel=" + houseLabel +
                '}';
    }
}