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
    int insert(HouseLabel record);

    /**
     * insert record to table selective
     *保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param record the record
     * @return insert count
     */
    int insertSelective(HouseLabel record);

    /**
     * select by primary key
     *保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param id primary key
     * @return object by primary key
     */
    HouseLabel selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *根据主键更新属性不为null的值
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(HouseLabel record);

    /**
     * update record
     *根据主键更新实体全部字段，null值会被更新
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(HouseLabel record);
}