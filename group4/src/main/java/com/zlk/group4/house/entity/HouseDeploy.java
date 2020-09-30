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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBed() {
        return bed;
    }

    public void setBed(Integer bed) {
        this.bed = bed;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    public Integer getConditioner() {
        return conditioner;
    }

    public void setConditioner(Integer conditioner) {
        this.conditioner = conditioner;
    }

    public Integer getWardrobe() {
        return wardrobe;
    }

    public void setWardrobe(Integer wardrobe) {
        this.wardrobe = wardrobe;
    }

    public Integer getDesk() {
        return desk;
    }

    public void setDesk(Integer desk) {
        this.desk = desk;
    }

    public Integer getChair() {
        return chair;
    }

    public void setChair(Integer chair) {
        this.chair = chair;
    }

    public Integer getSofa() {
        return sofa;
    }

    public void setSofa(Integer sofa) {
        this.sofa = sofa;
    }

    public Integer getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(Integer refrigerator) {
        this.refrigerator = refrigerator;
    }

    public Integer getWashing() {
        return washing;
    }

    public void setWashing(Integer washing) {
        this.washing = washing;
    }

    public Integer getTv() {
        return tv;
    }

    public void setTv(Integer tv) {
        this.tv = tv;
    }

    public Integer getHeater() {
        return heater;
    }

    public void setHeater(Integer heater) {
        this.heater = heater;
    }

    public Integer getStove() {
        return stove;
    }

    public void setStove(Integer stove) {
        this.stove = stove;
    }

    public Integer getMicrowave() {
        return microwave;
    }

    public void setMicrowave(Integer microwave) {
        this.microwave = microwave;
    }

    public Integer getLampblack() {
        return lampblack;
    }

    public void setLampblack(Integer lampblack) {
        this.lampblack = lampblack;
    }

    public Integer getDining() {
        return dining;
    }

    public void setDining(Integer dining) {
        this.dining = dining;
    }

    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }

    public Integer getLed() {
        return led;
    }

    public void setLed(Integer led) {
        this.led = led;
    }

    @Override
    public String toString() {
        return "HouseDeploy{" +
                "id=" + id +
                ", bed=" + bed +
                ", wifi=" + wifi +
                ", conditioner=" + conditioner +
                ", wardrobe=" + wardrobe +
                ", desk=" + desk +
                ", chair=" + chair +
                ", sofa=" + sofa +
                ", refrigerator=" + refrigerator +
                ", washing=" + washing +
                ", tv=" + tv +
                ", heater=" + heater +
                ", stove=" + stove +
                ", microwave=" + microwave +
                ", lampblack=" + lampblack +
                ", dining=" + dining +
                ", lock=" + lock +
                ", led=" + led +
                '}';
    }
}