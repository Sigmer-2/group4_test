package com.zlk.group4.ordinary.service;

import com.zlk.group4.ordinary.entity.HouseImg;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseImgService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseImg record);

    int insertSelective(HouseImg record);

    HouseImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseImg record);

    int updateByPrimaryKey(HouseImg record);

}

