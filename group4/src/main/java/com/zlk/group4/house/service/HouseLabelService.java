package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseLabel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseLabelService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseLabel record);

    int insertSelective(HouseLabel record);

    HouseLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseLabel record);

    int updateByPrimaryKey(HouseLabel record);

}


