package com.zlk.group4.user.entity;

/**
 * @author:sunjiahe
 * @date:2020/9/23
 * @descreption:
 */
public class UserPage {
    /**用户id*/
    private Integer userId;
    /**用户类型*/
    private String userRoleName;
    /**联系方式*/
    private String userTel;
    /**用户头像*/
    private String userImg;
    /**用户昵称*/
    private String userName;
    /**所在城市*/
    private String userPlace;
    /**用户性别*/
    private String userSex;
    /**密码*/
    private String userPassword;
    /***/
    private String sessionKey;
    /***/
    private Integer openId;

    public UserPage() {
    }

    public UserPage(Integer userId, String userRoleName, String userTel, String userImg, String userName, String userPlace, String userSex, String userPassword, String sessionKey, Integer openId) {
        this.userId = userId;
        this.userRoleName = userRoleName;
        this.userTel = userTel;
        this.userImg = userImg;
        this.userName = userName;
        this.userPlace = userPlace;
        this.userSex = userSex;
        this.userPassword = userPassword;
        this.sessionKey = sessionKey;
        this.openId = openId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
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

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "UserPage{" +
                "userId=" + userId +
                ", userRoleName='" + userRoleName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userName='" + userName + '\'' +
                ", userPlace='" + userPlace + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", openId=" + openId +
                '}';
    }
}
