package com.zlk.group4.house.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.zlk.group4.house.entity.Collect;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: sunshuai
 * Date: 2020-10-12
 * Time: 13:38
 */
    
@Mapper
public interface CollectMapper {
    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/13 16:19
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/13 16:20
     * @param record
     * @return int
     */
    int insert(Collect record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/13 16:22 
     * @param record
     * @return int
     */
    int insertSelective(Collect record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/13 16:22
     * @param id
     * @return com.zlk.group4.house.entity.Collect
     */
    Collect selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/13 16:27
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Collect record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/13 16:27
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Collect record);
    /**
     *根据userId和houseId查询Collect
     * @Auther sunshuai
     * @Date 2020/10/13 16:29
     * @param collectUserid
     * @param collectHouseid
     * @return com.zlk.group4.house.entity.Collect
     */
    Collect findAllByCollectUseridAndCollectHouseid(@Param("collectUserid")Integer collectUserid,@Param("collectHouseid")Integer collectHouseid);
    /**
     * 根据userId和houseId删除Collect
     * @Auther sunshuai
     * @Date 2020/10/14 9:00 
     * @param collectUserid
     * @param collectHouseid
     * @return int
     */
    int deleteByCollectUseridAndCollectHouseid(@Param("collectUserid")Integer collectUserid,@Param("collectHouseid")Integer collectHouseid);




}