package com.zlk.group4.house.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
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
     * 小区位置
     */
    private String estate;

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
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date checkinTime;

    /**
     * 租客性别（0：男女不限，1：男，2：女）
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
     * 地铁
     */
    @Transient
    private Metro metro;
    /**
     * 区域
     */
    @Transient
    private Region region;

    /**
     * 注入房间标签关联表
     * */
    @Transient
     private HouseRefLabel houseRefLabel;
     /**
     * 注入房间配置关联表
     * */
     @Transient
    private HouseRefDeploy houseRefDeploy;
    /**
     * 注入房屋图片关联表
     * */
    @Transient
    private List<HouseRefImg> houseRefImgs;

    /**
     * 注入用户房源关联表
     * */
    @Transient
    private HouseRefUser houseRefUser;


    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", houseType='" + houseType + '\'' +
                ", regionId=" + regionId +
                ", metroId=" + metroId +
                ", estate='" + estate + '\'' +
                ", listingsType='" + listingsType + '\'' +
                ", rentalMode='" + rentalMode + '\'' +
                ", roomType='" + roomType + '\'' +
                ", rent=" + rent +
                ", houseIntroduction='" + houseIntroduction + '\'' +
                ", checkinTime=" + checkinTime +
                ", sex=" + sex +
                ", call='" + call + '\'' +
                ", tel='" + tel + '\'' +
                ", code=" + code +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", metro=" + metro +
                ", region=" + region +
                ", houseRefLabel=" + houseRefLabel +
                ", houseRefDeploy=" + houseRefDeploy +
                ", houseRefImgs=" + houseRefImgs +
                ", houseRefUser=" + houseRefUser +
                '}';
    }
}