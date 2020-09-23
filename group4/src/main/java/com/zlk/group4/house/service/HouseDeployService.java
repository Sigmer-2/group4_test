package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseDeploy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseDeployService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseDeploy record);

    int insertSelective(HouseDeploy record);

    HouseDeploy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseDeploy record);

    int updateByPrimaryKey(HouseDeploy record);

}


