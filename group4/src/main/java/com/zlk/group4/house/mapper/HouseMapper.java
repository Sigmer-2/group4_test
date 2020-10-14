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
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:24
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:24
     * @param record
     * @return int
     */
    int insert(House record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:25
     * @param record
     * @return int
     */
    int insertSelective(House record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:25
     * @param id
     * @return com.zlk.group4.house.entity.House
     */
    House selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:25
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(House record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:26
     * @param record
     * @return int
     */
    int updateByPrimaryKey(House record);
    /**
     * 查询所有
     * @Auther sunshuai
     * @Date 2020/10/14 9:26
     * @return java.util.List<com.zlk.group4.house.entity.House>
     */
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
     * 查询该用户的浏览足迹
     * @description: *
     * @param map
     * @return:
     * @author: zhc
     * @time: 2020/10/13 14:26
     */
    List<Integer> findFoot(Map map);
    /**
     *
     * 查询该用户的收藏
     * @description: *
     * @param map
     * @return:
     * @author: zhc
     * @time: 2020/10/13 14:26
     */
    List<Integer> findCollect(Map map);
    /**
     *
     * 小程序查询收藏或足迹功能返回的房屋列表
     * @description: *
     * @param map
     * @return:
     * @author: zhc
     * @time: 2020/10/13 14:47
     */
    List<House> wxSelectFoot(Map map);
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