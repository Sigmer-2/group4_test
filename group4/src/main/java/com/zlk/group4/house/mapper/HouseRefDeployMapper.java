package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseRefDeploy;
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
public interface HouseRefDeployMapper {
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
    int insert(HouseRefDeploy record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(HouseRefDeploy record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    HouseRefDeploy selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(HouseRefDeploy record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(HouseRefDeploy record);

    /**
     * @Description:根据houseid查询房屋配置
     * @Auther sunshuai
     * @Date 2020/9/23 17:37
     * @param id houseId
     * @return com.zlk.group4.house.entity.HouseRefDeploy
     */
    HouseRefDeploy selectDeployByHouseId(Integer id);

    int findDeployIdbyHouseId(Integer id);
}