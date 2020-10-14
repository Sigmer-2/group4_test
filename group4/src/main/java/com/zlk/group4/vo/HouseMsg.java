package com.zlk.group4.vo;

import lombok.Data;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:页面显示所需的房源信息
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 15:31
 */
@Data
public class HouseMsg {

    /**
     * 房源id
     */
    private Integer id;
    /**
     * 房源类型
     */
    private String houseType;
    /**
     *区域位置
     */
    private String area;
    /**
     *地铁位置
     */
    private String metro;
    /**
     *小区位置
     */
    private String estate;
    /**
     *整套户型
     */
    private String listingsType;
    /**
     *出租方式
     */
    private String rentalMode;
    /**
     *房间类型
     */
    private String roomType;
    /**
     *月租金
     */
    private BigDecimal rent;
    /**
     *房屋标签
     */
    private String houseLabel;
    /**
     *房屋配置
     */
    private String houseDeploy;
    /**
     *房屋介绍
     */
    private String houseIntroduction;
    /**
     *可入住时间
     */
    private String checkinTime;
    /**
     *租客性别
     */
    private String sex;
    /**
     *房东称呼
     */
    private String call;
    /**
     *练习方式
     */
    private String tel;
}
