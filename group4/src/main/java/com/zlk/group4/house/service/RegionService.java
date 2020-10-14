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

    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:41
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:41
     * @param record
     * @return int
     */
    int insert(Region record);
    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:41
     * @param record
     * @return int
     */
    int insertSelective(Region record);
    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:42
     * @param id
     * @return com.zlk.group4.house.entity.Region
     */
    Region selectByPrimaryKey(Integer id);
    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:42
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Region record);
    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:42
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Region record);
    /**
     * 根据主键id，region字符串更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:42
     * @param str
     * @param id
     * @return int
     */
    int updateByString(String str,Integer id);
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
    /**
     * 返回新增regionId
     * @Auther sunshuai
     * @Date 2020/9/25 11:47
     * @param str 区域信息
     * @return int 新增regionId
     */
    int insertByString(String str);

}


