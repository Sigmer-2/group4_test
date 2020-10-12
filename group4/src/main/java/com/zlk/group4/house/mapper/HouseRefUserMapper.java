package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseRefUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface HouseRefUserMapper {
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
    int insert(HouseRefUser record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(HouseRefUser record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    HouseRefUser selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(HouseRefUser record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(HouseRefUser record);

    List<HouseRefUser> selectHouseByUserId(Integer id);
    /**
     *
     * 通过房屋id查询user
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/27 14:12
     */
    HouseRefUser selectUserByHouseId(Integer id);

    /**
     * 根据userId查询houseId
     * @Auther lihongying
     * @Date 2020/10/8 17:09
     * @param id
     * @return List
     */
     List selectHouseIdByUserId(Integer id);
}