package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseRefLabel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefLabelService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseRefLabel record);

    int insertSelective(HouseRefLabel record);

    HouseRefLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRefLabel record);

    int updateByPrimaryKey(HouseRefLabel record);

    HouseRefLabel selectLabelByHouseId(Integer id);

    String label(Integer id);

}


