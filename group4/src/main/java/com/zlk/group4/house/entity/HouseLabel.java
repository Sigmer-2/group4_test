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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShortRent() {
        return shortRent;
    }

    public void setShortRent(Integer shortRent) {
        this.shortRent = shortRent;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getSouthward() {
        return southward;
    }

    public void setSouthward(Integer southward) {
        this.southward = southward;
    }

    public Integer getAgencyfee() {
        return agencyfee;
    }

    public void setAgencyfee(Integer agencyfee) {
        this.agencyfee = agencyfee;
    }

    public Integer getToilet() {
        return toilet;
    }

    public void setToilet(Integer toilet) {
        this.toilet = toilet;
    }

    public Integer getBalcony() {
        return balcony;
    }

    public void setBalcony(Integer balcony) {
        this.balcony = balcony;
    }

    public Integer getElevator() {
        return elevator;
    }

    public void setElevator(Integer elevator) {
        this.elevator = elevator;
    }

    public Integer getBayWindow() {
        return bayWindow;
    }

    public void setBayWindow(Integer bayWindow) {
        this.bayWindow = bayWindow;
    }

    public Integer getDecoration() {
        return decoration;
    }

    public void setDecoration(Integer decoration) {
        this.decoration = decoration;
    }

    @Override
    public String toString() {
        return "HouseLabel{" +
                "id=" + id +
                ", shortRent=" + shortRent +
                ", payment=" + payment +
                ", southward=" + southward +
                ", agencyfee=" + agencyfee +
                ", toilet=" + toilet +
                ", balcony=" + balcony +
                ", elevator=" + elevator +
                ", bayWindow=" + bayWindow +
                ", decoration=" + decoration +
                '}';
    }
}