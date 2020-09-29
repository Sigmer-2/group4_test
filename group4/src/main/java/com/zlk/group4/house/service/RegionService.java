package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.Region;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface RegionService {


    int deleteByPrimaryKey(Integer id);

    int insert(Region record);

    int insertSelective(Region record);

    Region selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Region record);

    int updateByPrimaryKey(Region record);

    int updateByString(String str);
    /**
     *
     * 管理员更新房屋区域信息
     * @description: *
     * @param region
     * @return:
     * @author: zhc
     * @time: 2020/9/29 17:44
     */
    Integer adminUpdateRegion(Region region);

}


