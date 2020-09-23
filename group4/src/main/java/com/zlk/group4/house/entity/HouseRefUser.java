package com.zlk.group4.house.entity;

import com.zlk.group4.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description:房屋用户关联
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
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
    /**
     * 注入用户表
     * */
    private User user;
}