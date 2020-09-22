package com.zlk.group4.ordinary.mapper;

import com.zlk.group4.ordinary.entity.HouseDeploy;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 房间配置
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface HouseDeployMapper {
    
    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:00 
     * @param id primaryKey
     * @return int  deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 16:01 
     * @param record the record
     * @return int insert count
     */
    int insert(HouseDeploy record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:01 
     * @param record the record
     * @return int insert count
     */
    int insertSelective(HouseDeploy record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:02
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.HouseDeploy
     */
    HouseDeploy selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:03
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(HouseDeploy record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 16:03
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(HouseDeploy record);
}