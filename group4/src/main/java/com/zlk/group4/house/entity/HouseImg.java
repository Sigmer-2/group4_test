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
public class HouseImg {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 图片路径
     */
    private String imgUrl;

    /**
     * 是否为封面（0：不是，1：是）
     */
    private Integer imgPage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getImgPage() {
        return imgPage;
    }

    public void setImgPage(Integer imgPage) {
        this.imgPage = imgPage;
    }

    @Override
    public String toString() {
        return "HouseImg{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgPage=" + imgPage +
                '}';
    }
}