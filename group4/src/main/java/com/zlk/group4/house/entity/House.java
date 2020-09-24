package com.zlk.group4.house.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description: 房屋信息
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class House {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 房源类型
     */
    private String houseType;

    /**
     * 区域id
     */
    private Integer regionId;

    /**
     * 地铁id
     */
    private Integer metroId;

    /**
     * 房源户型
     */
    private String listingsType;

    /**
     * 出租方式
     */
    private String rentalMode;

    /**
     * 房间类型
     */
    private String roomType;

    /**
     * 月租金
     */
    private BigDecimal rent;
    /**
     * 房屋介绍
     */
    private String houseIntroduction;

    /**
     * 可入住时间
     */
    private Date checkinTime;

    /**
     * 租客性别（0：男女均可，1：仅限男，2：仅限女）
     */
    private Integer sex;

    /**
     * 房东称呼
     */
    private String call;

    /**
     * 联系方式
     */
    private String tel;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 注入用户房源关联表
     * */
    private HouseRefUser houseRefUser;
    /**
     *注入区域
     * */
    private Region region;
    /**
     * 注入地铁
     * */
    private Metro metro;
    /**
     * 注入房间标签关联表
     * */
    private HouseRefLabel houseRefLabel;
    /**
     * 注入房间配置关联表
     * */
    private HouseRefDeploy houseRefDeploy;
    /**
     * 注入房屋图片关联表
     * */
    private List<HouseRefImg> houseRefImgs;
}