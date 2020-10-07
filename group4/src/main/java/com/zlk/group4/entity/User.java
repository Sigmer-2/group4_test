package com.zlk.group4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 招租用户和管理员以及租房用户的各种属性
 * @author: zhc
 * @time: 2020/9/22 10:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**用户id*/
    private Integer id;
    /**角色id*/
    private Integer userRoleId;
    /**联系方式*/
    private String tel;
    /**用户头像*/
    private String userImg;
    /**用户昵称*/
    private String userName;
    /**所在城市*/
    private String userPlace;
    /**性别*/
    private String userSex;
    /**用户密码*/
    private String userPassword;
    /**用户session*/
    private String sessionKey;
    /**OPEN ID*/
    private String openId;
    /**商户类型*/
    private String type;
    /**商家类型*/
    private String businessName;
    /**房源量*/
    private Integer houseNumber;


    public User(String sessionKey, String openId) {
        this.sessionKey = sessionKey;
        this.openId = openId;
    }

    /*public User(Integer id, Integer userRoleId, String tel, String userImg, String userName, String userPlace, String userSex, String userPassword, String sessionKey, String openId, String type, String businessName, Integer houseNumber) {
            this.id = id;
            this.userRoleId = userRoleId;
            this.tel = tel;
            this.userImg = userImg;
            this.userName = userName;
            this.userPlace = userPlace;
            this.userSex = userSex;
            this.userPassword = userPassword;
            this.sessionKey = sessionKey;
            this.openId = openId;
            this.type = type;
            this.businessName = businessName;
            this.houseNumber = houseNumber;
        }
    */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPlace() {
        return userPlace;
    }

    public void setUserPlace(String userPlace) {
        this.userPlace = userPlace;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userRoleid=" + userRoleId +
                ", tel='" + tel + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userName='" + userName + '\'' +
                ", userPlace='" + userPlace + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", openId=" + openId +
                ", type='" + type + '\'' +
                ", business_name='" + businessName + '\'' +
                ", house_number=" + houseNumber +
                '}';
    }
}
