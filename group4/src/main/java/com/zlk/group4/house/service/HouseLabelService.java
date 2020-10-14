package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseLabel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseLabelService {


    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 10:00
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 10:00
     * @param record
     * @return int
     */
    int insert(HouseLabel record);

    /**
     * 插入全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 10:00
     * @param record
     * @return int
     */
    int insertSelective(HouseLabel record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 10:00
     * @param id
     * @return com.zlk.group4.house.entity.HouseLabel
     */
    HouseLabel selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 10:01
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseLabel record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 10:01
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseLabel record);

    /**
     * 根据标签字符串更新HouseLabel内容
     * @Auther sunshuai
     * @Date 2020/9/23 22:06
     * @param str
     * @return int
     */
    int updateByString(String str,Integer id);

    /**
     * 根据标签字符串新增HouseLabel内容
     * @Auther sunshuai
     * @Date 2020/9/25 13:51
     * @param str
     * @return int 新增houseLabelId
     */
    int insertHouseLabelByString(String str);

}


