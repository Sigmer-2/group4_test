package com.zlk.group4.ordinary.mapper;

import com.zlk.group4.ordinary.entity.Region;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 区域
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface RegionMapper {

    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 17:05
     * @param id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 17:05
     * @param record the record
     * @return int insert count
     */
    int insert(Region record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 17:05
     * @param record the record
     * @return int insert count
     */
    int insertSelective(Region record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 17:06
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.Region
     */
    Region selectByPrimaryKey(Integer id);

    /**
     * @Description: primary key
     * @Auther sunshuai
     * @Date 2020/9/22 17:07
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(Region record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 17:07
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(Region record);
}