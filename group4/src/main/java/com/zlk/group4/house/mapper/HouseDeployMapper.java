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
    int insert(HouseDeploy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(HouseDeploy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    HouseDeploy selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *根据主键更新属性不为null的值
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(HouseDeploy record);

    /**
     * update record
     *根据主键更新实体全部字段，null值会被更新
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(HouseDeploy record);
}