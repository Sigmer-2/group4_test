package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.House;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 房源
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface HouseMapper {

    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:13
     * @param id id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 16:14
     * @param record the record
     * @return int insert count
     */
    int insert(House record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:14
     * @param record the record
     * @return int insert count
     */
    int insertSelective(House record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:15
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.House
     */
    House selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:15
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(House record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 16:15
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(House record);
}