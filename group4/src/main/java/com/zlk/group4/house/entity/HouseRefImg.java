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
}