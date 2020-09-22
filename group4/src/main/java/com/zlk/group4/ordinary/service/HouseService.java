package com.zlk.group4.ordinary.service;

import com.zlk.group4.ordinary.entity.House;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseService {

    /**
     * @Description: 根据主键删除房屋信息
     * @Auther sunshuai
     * @Date 2020/9/22 17:16
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

}

