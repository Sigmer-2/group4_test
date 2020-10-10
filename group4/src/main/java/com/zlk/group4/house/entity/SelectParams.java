package com.zlk.group4.house.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 微信小程序中所选择的条件
 * @author: zhc
 * @time: 2020/10/9 15:58
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectParams {
    /**页数*/
    private Integer page;
    /**每页大小*/
    private Integer limit;
    /**搜索框中的数据*/
    private String searchValue;
    /**区域选择框中的区域数据*/
    private Integer area;
    /**区域选择框中的街道数据*/
    private Integer street;
    /**地铁选择框中的线路数据*/
    private Integer line;
    /**地铁选择框中的站点数据*/
    private Integer station;
    /**租金数据*/
    private Integer rent;
    /**出租方式数据*/
    private Integer rentalModel;
    /**房源类型数据*/
    private Integer houseType;
    /**性别要求*/
    private Integer sex;
    /**户型数据*/
    private List<Integer> listingType;
    /**房屋标签数据*/
    private List<Integer> label;
    /**排序数据*/
    private Integer sort;

    @Override
    public String toString() {
        return "SelectParams{" +
                "page=" + page +
                ", limit=" + limit +
                ", searchValue='" + searchValue + '\'' +
                ", area=" + area +
                ", street=" + street +
                ", line=" + line +
                ", station=" + station +
                ", rent=" + rent +
                ", rentalModel=" + rentalModel +
                ", houseType=" + houseType +
                ", sex=" + sex +
                ", listingType=" + listingType +
                ", label=" + label +
                ", sort=" + sort +
                '}';
    }
}
