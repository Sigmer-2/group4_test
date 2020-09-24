package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseLabel;
import com.zlk.group4.house.entity.HouseRefLabel;
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
public interface HouseRefLabelMapper {
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
    int insert(HouseRefLabel record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(HouseRefLabel record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    HouseRefLabel selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(HouseRefLabel record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(HouseRefLabel record);

    /**
     * @Description:根据房源id获取房间标签信息
     * @Auther sunshuai
     * @Date 2020/9/23 14:45
     * @param id houseid
     * @return java.util.List<com.zlk.group4.house.entity.HouseRefLabel>
     */
    HouseRefLabel selectLabelByHouseId(Integer id);
}