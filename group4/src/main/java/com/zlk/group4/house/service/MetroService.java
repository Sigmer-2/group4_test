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

    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:44
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 更新全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:44
     * @param record
     * @return int
     */
    int insert(Metro record);
    /**
     * 更新全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:44
     * @param record
     * @return int
     */
    int insertSelective(Metro record);
    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:44
     * @param id
     * @return com.zlk.group4.house.entity.Metro
     */
    Metro selectByPrimaryKey(Integer id);
    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:44
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Metro record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:45
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Metro record);
    /**
     * 根据主键id，metro字符串更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:45
     * @param str
     * @param id
     * @return int
     */
    int updateByString(String str,Integer id);
    /**
     * 根据地铁信息返回新增id
     * @Auther sunshuai
     * @Date 2020/9/25 11:45
     * @param str
     * @return int metroId
     */
    int insertByString(String str);
    /**
     *
     * 管理员更新房屋地铁信息
     * @description: *
     * @param metro
     * @return:
     * @author: zhc
     * @time: 2020/9/29 17:44
     */
    Integer adminUpdateMetro(Metro metro);


}



