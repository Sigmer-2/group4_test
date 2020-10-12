package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseDeploy;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseDeployService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseDeploy record);

    int insertSelective(HouseDeploy record);

    HouseDeploy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseDeploy record);

    int updateByPrimaryKey(HouseDeploy record);

    /**
     * 根据房源配置信息、房源id更新
     * @Auther sunshuai
     * @Date 2020/9/23 21:37
     * @param str 配置信息中间用中文"，"分开
     * @return int 返回受影响行数
     */
    int updateByStr(String str,Integer id);

    /**
     * 根据房源配置信息新增并返回新增Id
     * @Auther sunshuai
     * @Date 2020/9/25 11:53
     * @param str
     * @return int 新增id
     */
    int insertByStr(String str);

}


