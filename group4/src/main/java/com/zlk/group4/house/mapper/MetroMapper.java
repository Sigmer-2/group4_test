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
    int insert(Metro record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Metro record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Metro selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Metro record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
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