package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseRefDeploy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefDeployService {


    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:58
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:58
     * @param record
     * @return int
     */
    int insert(HouseRefDeploy record);

    /**
     * 插入全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:58
     * @param record
     * @return int
     */
    int insertSelective(HouseRefDeploy record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:59
     * @param id
     * @return com.zlk.group4.house.entity.HouseRefDeploy
     */
    HouseRefDeploy selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:59
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseRefDeploy record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:59
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseRefDeploy record);

    /**
     * 根据houseId查询房屋配置
     * @Auther sunshuai
     * @Date 2020/9/23 17:37
     * @param id houseId
     * @return com.zlk.group4.house.entity.HouseRefDeploy
     */
    HouseRefDeploy selectDeployByHouseId(Integer id);
    /**
     * 根据houseId返回配置字符串
     * @Auther sunshuai
     * @Date 2020/9/23 19:52
     * @param id houseId
     * @return java.lang.String
     */
    String houseDeploy(Integer id);

    /**
     * 根据houseId查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:59
     * @param id
     * @return int
     */
    int findDeployIdbyHouseId(Integer id);


}


