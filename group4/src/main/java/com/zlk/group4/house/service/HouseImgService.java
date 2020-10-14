package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseImg;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseImgService {


    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 10:01
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 10:01
     * @param record
     * @return int
     */
    int insert(HouseImg record);

    /**
     * 插入全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 10:01
     * @param record
     * @return int
     */
    int insertSelective(HouseImg record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 10:02
     * @param id
     * @return com.zlk.group4.house.entity.HouseImg
     */
    HouseImg selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 10:02
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseImg record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 10:02
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseImg record);

}


