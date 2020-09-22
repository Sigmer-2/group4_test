package com.zlk.group4.ordinary.mapper;

import com.zlk.group4.ordinary.entity.HouseRefDeploy;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 房源配置
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface HouseRefDeployMapper {

    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:17
     * @param id id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 16:17
     * @param record the record
     * @return int insert count
     */
    int insert(HouseRefDeploy record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:18
     * @param record the record
     * @return int insert count
     */
    int insertSelective(HouseRefDeploy record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:27
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.HouseRefDeploy
     */
    HouseRefDeploy selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:27
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(HouseRefDeploy record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 16:28
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(HouseRefDeploy record);
}