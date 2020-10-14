package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.Region;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface RegionMapper {
    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:01
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:02
     * @param record
     * @return int
     */
    int insert(Region record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:02
     * @param record
     * @return int
     */
    int insertSelective(Region record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:02
     * @param id
     * @return com.zlk.group4.house.entity.Region
     */
    Region selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:05
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Region record);

    /**
     * 根据主键更新全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:06
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Region record);
    /**
     *
     * 管理员更新房屋区域信息
     * @description: *
     * @param region
     * @return:
     * @author: zhc
     * @time: 2020/9/29 17:46
     */
    Integer adminUpdateRegion(Region region);
}