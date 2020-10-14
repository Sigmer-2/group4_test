package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseLabel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface HouseLabelMapper {
    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:26
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:27
     * @param record
     * @return int
     */
    int insert(HouseLabel record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:27
     * @param record
     * @return int
     */
    int insertSelective(HouseLabel record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:28
     * @param id
     * @return com.zlk.group4.house.entity.HouseLabel
     */
    HouseLabel selectByPrimaryKey(Integer id);

   /**
    * 根据主键更新属性不为null的值
    * @Auther sunshuai
    * @Date 2020/10/14 9:28
    * @param record
    * @return int
    */
    int updateByPrimaryKeySelective(HouseLabel record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:28
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseLabel record);
}