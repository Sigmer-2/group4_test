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

    List<HouseRefDeploy> selectDeployByHouseId(Integer id);

}


