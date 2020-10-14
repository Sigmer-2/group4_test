package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseDeploy;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface HouseDeployMapper {
    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:30
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:30
     * @param record
     * @return int
     */
    int insert(HouseDeploy record);

    /**
     * 插入全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:30
     * @param record
     * @return int
     */
    int insertSelective(HouseDeploy record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:31
     * @param id
     * @return com.zlk.group4.house.entity.HouseDeploy
     */
    HouseDeploy selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:31
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseDeploy record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:32
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseDeploy record);
}