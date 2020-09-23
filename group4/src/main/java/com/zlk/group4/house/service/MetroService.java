package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.Metro;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface MetroService {


    int deleteByPrimaryKey(Integer id);

    int insert(Metro record);

    int insertSelective(Metro record);

    Metro selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Metro record);

    int updateByPrimaryKey(Metro record);

}

