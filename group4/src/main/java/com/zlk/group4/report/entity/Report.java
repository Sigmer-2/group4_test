package com.zlk.group4.report.entity;

import com.zlk.group4.entity.User;
import com.zlk.group4.house.entity.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Report
 * @program: group4
 * @description: 举报实体类
 * @author: wujian
 * @Date: 2020/9/22 17:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    /**举报编号*/
    private Integer id;
    /**举报用户编号*/
    private Integer reportUserId;
    /**被举报房间编号*/
    private Integer reportHouseId;
    /**举报原因*/
    private String reportReason;
    /**举报详情*/
    private String reportDetails;
    /**举报处理状态*/
    private Integer reportStatus;
    /**注入房间对象*/
    private House house;
    /**注入用户对象*/
    private User user;
    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reportUserId=" + reportUserId +
                ", reportHouseId=" + reportHouseId +
                ", reportReason='" + reportReason + '\'' +
                ", reportDetails='" + reportDetails + '\'' +
                ", reportStatus=" + reportStatus +
                '}';
    }
}
