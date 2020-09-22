package com.zlk.group4.ordinary.service;

import com.zlk.group4.ordinary.entity.HouseRefImg;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefImgService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseRefImg record);

    int insertSelective(HouseRefImg record);

    HouseRefImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRefImg record);

    int updateByPrimaryKey(HouseRefImg record);

}

