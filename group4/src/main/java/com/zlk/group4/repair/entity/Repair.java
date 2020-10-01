package com.zlk.group4.repair.entity;

import com.zlk.group4.entity.User;
import com.zlk.group4.house.entity.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Repair
 * @program: group4
 * @description: 维修实体类
 * @author: wujian
 * @Date: 2020/9/24 10:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repair {
    /**维修编号*/
    private Integer id;
    /**报修人员编号*/
    private Integer repairUserId;
    /**被报修房间编号*/
    private Integer repairHouseId;
    /**故障描述*/
    private String repairDescribe;
    /**维修状态*/
    private Integer repairStatus;
    /**注入房间对象*/
    private House house;
    /**注入用户对象*/
    private User user;

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", repairUserId=" + repairUserId +
                ", repairHouseId=" + repairHouseId +
                ", repairDescribe='" + repairDescribe + '\'' +
                ", repairStatus='" + repairStatus + '\'' +
                '}';
    }
}
