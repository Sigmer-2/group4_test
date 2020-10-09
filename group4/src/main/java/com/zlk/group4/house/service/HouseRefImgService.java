package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseRefImg;

import java.util.List;

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

    List<HouseRefImg> selectImgByHouseId(Integer id);


}


