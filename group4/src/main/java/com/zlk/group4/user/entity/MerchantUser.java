package com.zlk.group4.user.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: lihongying
 * Date: 2020-09-27
 * Time: 18:41
 */
@Data
public class MerchantUser {
    /**
    * userid
    */
    private Integer id;

    /**
    * 用户类型
    */
    private Integer userRoleid;

    /**
    * 联系方式
    */
    private String tel;

    /**
    * 用户头像
    */
    private String userImg;

    /**
    * 用户昵称
    */
    private String userName;

    /**
    * 所在城市
    */
    private String userPlace;

    /**
    * 用户性别
    */
    private String userSex;

    /**
    * 密码
    */
    private String userPassword;

    /**
    * ...
    */
    private String sessionKey;

    /**
    * 作用相当userid
    */
    private String openId;

    /**
    * 商户类型
    */
    private String type;

    /**
    * 商家名称
    */
    private String businessName;

    /**
    * 房源量
    */
    private Integer houseNumber;
}