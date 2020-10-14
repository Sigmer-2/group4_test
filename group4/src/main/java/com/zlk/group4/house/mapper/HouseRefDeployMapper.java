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
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:22
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:22
     * @param record
     * @return int
     */
    int insert(HouseRefDeploy record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:22
     * @param record
     * @return int
     */
    int insertSelective(HouseRefDeploy record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:23
     * @param id
     * @return com.zlk.group4.house.entity.HouseRefDeploy
     */
    HouseRefDeploy selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:23
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseRefDeploy record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:23
     * @param record
     * @return int
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

    /**
     * 通过HouseId查询deployId
     * @Auther sunshuai
     * @Date 2020/10/14 9:24
     * @param id
     * @return int
     */
    int findDeployIdbyHouseId(Integer id);
}