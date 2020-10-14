package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseRefUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface HouseRefUserMapper {
    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:12
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:13
     * @param record
     * @return int
     */
    int insert(HouseRefUser record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:13
     * @param record
     * @return int
     */
    int insertSelective(HouseRefUser record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:13
     * @param id
     * @return com.zlk.group4.house.entity.HouseRefUser
     */
    HouseRefUser selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:13
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseRefUser record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:14
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseRefUser record);

    /**
     * 根据userId查询houserefuser和user信息
     * @Auther sunshuai
     * @Date 2020/10/14 9:14
     * @param id
     * @return java.util.List<com.zlk.group4.house.entity.HouseRefUser>
     */
    List<HouseRefUser> selectHouseByUserId(Integer id);
    /**
     *
     * 通过房屋id查询user
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/27 14:12
     */
    HouseRefUser selectUserByHouseId(Integer id);

    /**
     * 根据userId查询houseId
     * @Auther lihongying
     * @Date 2020/10/8 17:09
     * @param id
     * @return List
     */
     List<Integer> selectHouseIdByUserId(Integer id);

     /**
      * 通过userId和HouseId查询id
      * @Auther sunshuai
      * @Date 2020/10/14 9:17
      * @param uid
      * @param hid
      * @return int
      */
     int findIdByUserIdAndHouseId(@Param("userId")Integer uid, @Param("houseId")Integer hid);
}