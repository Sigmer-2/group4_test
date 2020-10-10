package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.entity.HouseIdParam;
import org.apache.ibatis.annotations.Mapper;import java.util.List;import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface HouseMapper {
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
    int insert(House record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(House record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    House selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(House record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(House record);

    List<House> selectAll();
    /**
     * 根据id查询房源信息包含地铁、标签、配置
     * @Auther sunshuai
     * @Date 2020/10/8 9:59
     * @param id
     * @return com.zlk.group4.house.entity.House
     */
    House selectAllById(Integer id);

    /**
     *
     *
     * @description: 管理员-房屋信息-输出
     * @param map
     * @description: 管理员-房屋信息-输出
     * @return: 房屋信息列表
     * @author: zhc
     * @time: 2020/9/23 16:51
     */
    List<House> adminManageHouse(Map map);
    /**
     *
     *
     * @description: 管理员-房屋信息-查询
     * @param map
     * @description: 管理员-房屋信息-查询
     * @return: 房屋信息列表
     * @author: zhc
     * @time: 2020/9/23 16:51
     */
    List<House> adminFindHouse(Map map);
    /**
     *
     * 招租房屋总数
     * @description:
     * @param
     * @return:
     * @author: zhc
     * @time: 2020/9/25 10:16
     */
    Integer findHouseCount();
    /**
     *
     * 管理员删除单条房屋信息
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:54
     */
    Integer adminDeleteHouseById(Integer id);
    /**
     *
     * 管理员删除单条房屋信息与用户之间的关联
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:54
     */
    Integer deleteRefUserById(Integer id);
    /**
     *
     * 管理员删除单条房屋信息与标签之间的关联
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:54
     */
    Integer deleteRefLabelById(Integer id);
    /**
     *
     * 管理员删除单条房屋信息与配置之间的关联
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:54
     */
    Integer deleteRefDeployById(Integer id);
    /**
     *
     * 管理员删除多条房屋信息
     * @description: *
     * @param param
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:54
     */
    Integer adminDeleteHouseByIds(HouseIdParam param);
    /**
     *
     * 管理员删除多条房屋信息与用户之间的关联
     * @description: *
     * @param param
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:54
     */
    Integer deleteRefUserByIds(HouseIdParam param);
    /**
     *
     * 管理员删除多条房屋信息与标签之间的关联
     * @description: *
     * @param param
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:54
     */
    Integer deleteRefLabelByIds(HouseIdParam param);
    /**
     *
     * 管理员删除多条房屋信息与配置之间的关联
     * @description: *
     * @param param
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:54
     */
    Integer deleteRefDeployByIds(HouseIdParam param);
    /**
     *
     * 管理员对房屋信息进行修改
     * @description: *
     * @param house
     * @return:
     * @author: zhc
     * @time: 2020/9/29 19:12
     */
    Integer adminUpdateHouseById(House house);
    /**
     *
     * 微信小程序对房屋的查询
     * @description: *
     * @param map
     * @return:
     * @author: zhc
     * @time: 2020/10/10 14:15
     */
    List<House> wxSelectHouse(Map map);
}