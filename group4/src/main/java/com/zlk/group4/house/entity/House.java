package com.zlk.group4.house.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 房屋信息
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
public class House {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 房源类型
     */
    private String houseType;

    /**
     * 区域id
     */
    private Integer regionId;

    /**
     * 地铁id
     */
    private Integer metroId;

    /**
     * 房源户型
     */
    private String listingsType;

    /**
     * 出租方式
     */
    private String rentalMode;

    /**
     * 房间类型
     */
    private String roomType;

    /**
     * 月租金
     */
    private BigDecimal rent;

    /**
     * 房屋照片
     */
    private String houseImg;

    /**
     * 房屋标签
     */
    private Integer houseLable;

    /**
     * 房屋配置
     */
    private Integer houseDeploy;

    /**
     * 房屋介绍
     */
    private String houseIntroduction;

    /**
     * 可入住时间
     */
    private LocalDate checkinTime;

    /**
     * 租客性别（0：男女不限，1：男，2：女）
     */
    private Integer sex;

    /**
     * 房东称呼
     */
    private String call;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}