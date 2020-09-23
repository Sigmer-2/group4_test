package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseRefUser;
import com.zlk.group4.vo.HouseMsg;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefUserService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseRefUser record);

    int insertSelective(HouseRefUser record);

    HouseRefUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRefUser record);

    int updateByPrimaryKey(HouseRefUser record);

    List<HouseMsg> listAll();


}


