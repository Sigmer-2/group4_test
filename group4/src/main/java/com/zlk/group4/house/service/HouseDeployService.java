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


    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 10:05
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 10:06
     * @param record
     * @return int
     */
    int insert(HouseDeploy record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 10:06
     * @param record
     * @return int
     */
    int insertSelective(HouseDeploy record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 10:06
     * @param id
     * @return com.zlk.group4.house.entity.HouseDeploy
     */
    HouseDeploy selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 10:06
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseDeploy record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 10:06
     * @param record
     * @return int
     */
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


