package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseRefLabel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 房源标签
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface HouseRefLabelMapper {

    /**
     * @Description: by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:33
     * @param id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 16:45
     * @param record the record
     * @return int insert count
     */
    int insert(HouseRefLabel record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:46
     * @param record the record
     * @return int insert count
     */
    int insertSelective(HouseRefLabel record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:46
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.HouseRefLabel
     */
    HouseRefLabel selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:49
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(HouseRefLabel record);

    /**
     * @Description: update record
     * @Auther sunshuai the updated record
     * @Date 2020/9/22 16:52
     * @param record
     * @return int update count
     */
    int updateByPrimaryKey(HouseRefLabel record);
}