package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseRefDeploy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefDeployService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseRefDeploy record);

    int insertSelective(HouseRefDeploy record);

    HouseRefDeploy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRefDeploy record);

    int updateByPrimaryKey(HouseRefDeploy record);

    /**
     * 根据houseId查询房屋配置
     * @Auther sunshuai
     * @Date 2020/9/23 17:37
     * @param id houseId
     * @return com.zlk.group4.house.entity.HouseRefDeploy
     */
    HouseRefDeploy selectDeployByHouseId(Integer id);
    /**
     * 根据houseId返回配置字符串
     * @Auther sunshuai
     * @Date 2020/9/23 19:52
     * @param id houseId
     * @return java.lang.String
     */
    String houseDeploy(Integer id);


}


