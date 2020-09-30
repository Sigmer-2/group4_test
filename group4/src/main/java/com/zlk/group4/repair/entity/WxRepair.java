package com.zlk.group4.repair.entity;

import com.zlk.group4.entity.User;
import com.zlk.group4.house.entity.House;
import lombok.Data;

import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: lihongying
 * Date: 2020-09-27
 * Time: 21:42
 */
@Data
public class WxRepair {
    /**
    * 维修编号
    */
    private Integer id;

    /**
    * 报修用户编号
    */
    private Integer repairUserid;

    /**
    * 被报修房间编号
    */
    private Integer repairHouseid;

    /**
    * 故障描述
    */
    private String repairDescribe;

    /**
    * 维修状态：0代表未维修，1代表已维修
    */
    private Integer repairStatus;

    /**
     * 注入房源表
     * */
    @Transient
    private House house;

}