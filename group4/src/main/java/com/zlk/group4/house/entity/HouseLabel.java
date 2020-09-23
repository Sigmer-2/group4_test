package com.zlk.group4.house.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 房屋标签
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
public class HouseLabel {
    /**
     * 自增id（统一值，0：无，1：有）
     */
    private Integer id;

    /**
     * 可短租
     */
    private Integer shortRent;

    /**
     * 月付
     */
    private Integer payment;

    /**
     * 南向
     */
    private Integer southward;

    /**
     * 无中介费
     */
    private Integer agencyfee;

    /**
     * 独卫
     */
    private Integer toilet;

    /**
     * 独立阳台
     */
    private Integer balcony;

    /**
     * 电梯房
     */
    private Integer elevator;

    /**
     * 带飘窗
     */
    private Integer bayWindow;

    /**
     * 精装修
     */
    private Integer decoration;
}