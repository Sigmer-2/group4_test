package com.zlk.group4.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class HouseDeploy {
    /**
     * 自增id（统一值0：没有，1：有）
     */
    private Integer id;

    /**
     * 床
     */
    private Integer bed;

    /**
     * wifi
     */
    private Integer wifi;

    /**
     * 空调
     */
    private Integer conditioner;

    /**
     * 衣柜
     */
    private Integer wardrobe;

    /**
     * 书桌
     */
    private Integer desk;

    /**
     * 椅子
     */
    private Integer chair;

    /**
     * 沙发
     */
    private Integer sofa;

    /**
     * 冰箱
     */
    private Integer refrigerator;

    /**
     * 洗衣机
     */
    private Integer washing;

    /**
     * 电视机
     */
    private Integer tv;

    /**
     * 热水器
     */
    private Integer heater;

    /**
     * 燃气灶
     */
    private Integer stove;

    /**
     * 微波炉
     */
    private Integer microwave;

    /**
     * 油烟机
     */
    private Integer lampblack;

    /**
     * 餐桌椅
     */
    private Integer dining;

    /**
     * 智能锁
     */
    private Integer lock;

    /**
     * 台灯
     */
    private Integer led;
}