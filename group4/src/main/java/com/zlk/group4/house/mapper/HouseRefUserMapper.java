package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseRefUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 房源用户
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface HouseRefUserMapper {

    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:53
     * @param id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 16:56
     * @param record the record
     * @return int insert count
     */
    int insert(HouseRefUser record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:57
     * @param record the record
     * @return int insert count
     */
    int insertSelective(HouseRefUser record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 17:00
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.HouseRefUser
     */
    HouseRefUser selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 17:01
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(HouseRefUser record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 17:01
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(HouseRefUser record);
}