package com.zlk.group4.house.entity;

import com.zlk.group4.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Transient
    private House house;
    /**
     * 注入用户表
     * */
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "HouseRefUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", houseId=" + houseId +
                ", house=" + house +
                ", user=" + user +
                '}';
    }
}