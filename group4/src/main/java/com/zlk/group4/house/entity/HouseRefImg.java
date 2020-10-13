package com.zlk.group4.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * Description: 房屋照片关联
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Transient
    /**
     * 注入房屋照片表
     * */
    private HouseImg houseImg;

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

    public Integer getHouseImgId() {
        return houseImgId;
    }

    public void setHouseImgId(Integer houseImgId) {
        this.houseImgId = houseImgId;
    }

    public HouseImg getHouseImg() {
        return houseImg;
    }

    public void setHouseImg(HouseImg houseImg) {
        this.houseImg = houseImg;
    }

    @Override
    public String toString() {
        return "HouseRefImg{" +
                "id=" + id +
                ", houseId=" + houseId +
                ", houseImgId=" + houseImgId +
                ", houseImg=" + houseImg +
                '}';
    }
}