package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.Metro;
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
public interface MetroMapper {
    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:09
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:09
     * @param record
     * @return int
     */
    int insert(Metro record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:09
     * @param record
     * @return int
     */
    int insertSelective(Metro record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:10
     * @param id
     * @return com.zlk.group4.house.entity.Metro
     */
    Metro selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:10
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Metro record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:11
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Metro record);
    /**
     *
     * 管理员更新房屋地铁信息
     * @description: *
     * @param metro
     * @return:
     * @author: zhc
     * @time: 2020/9/29 17:46
     */
    Integer adminUpdateMetro(Metro metro);
}