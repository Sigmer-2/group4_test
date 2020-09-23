package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseLabel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 房屋标签
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface HouseLabelMapper {

    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:10
     * @param id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 16:10
     * @param record record the record
     * @return int insert count
     */
    int insert(HouseLabel record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:11
     * @param record the record
     * @return int insert count
     */
    int insertSelective(HouseLabel record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:12
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.HouseLabel
     */
    HouseLabel selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:12
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(HouseLabel record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 16:12
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(HouseLabel record);
}