package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.House;
import org.apache.ibatis.annotations.Mapper;import java.util.List;import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface HouseMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(House record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(House record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    House selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(House record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(House record);

    List<House> selectAll();

    House selectAllById(Integer id);

    /**
     *
     *
     * @description: 管理员-房屋信息-输出
     * @param map
     * @description: 管理员-房屋信息-输出
     * @return: 房屋信息列表
     * @author: zhc
     * @time: 2020/9/23 16:51
     */
    List<House> adminManageHouse(Map map);
    /**
     *
     * 招租房屋总数
     * @description:
     * @param
     * @return:
     * @author: zhc
     * @time: 2020/9/25 10:16
     */
    Integer findHouseCount();

}