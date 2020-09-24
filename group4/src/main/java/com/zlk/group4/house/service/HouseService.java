package com.zlk.group4.house.service;
import java.util.List;

import com.zlk.group4.house.entity.House;
import com.zlk.group4.vo.HouseMsg;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 11:46
 */

public interface HouseService {


    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> selectAll();

    House selectAllById(Integer id);



}

