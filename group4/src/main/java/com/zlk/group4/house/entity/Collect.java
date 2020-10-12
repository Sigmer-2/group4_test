package com.zlk.group4.house.entity;

import java.util.Date;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: sunshuai
 * Date: 2020-10-12
 * Time: 13:38
 */
    
@Data
public class Collect {
    /**
    * 收藏id
    */
    private Integer id;

    /**
    * 用户id
    */
    private Integer collectUserid;

    /**
    * 房屋id
    */
    private Integer collectHouseid;

    /**
    * 收藏时间
    */
    private Date collectTime;
}