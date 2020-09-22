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
    private Integer userRoleid;
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
    private Integer openId;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userRoleid=" + userRoleid +
                ", tel='" + tel + '\'' +
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
