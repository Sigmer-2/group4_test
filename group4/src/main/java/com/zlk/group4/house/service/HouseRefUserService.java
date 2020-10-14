package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseRefUser;
import com.zlk.group4.vo.HouseMsg;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefUserService {


    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:49
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:50
     * @param record
     * @return int
     */
    int insert(HouseRefUser record);

    /**
     * 插入全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:50
     * @param record
     * @return int
     */
    int insertSelective(HouseRefUser record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:50
     * @param id
     * @return com.zlk.group4.house.entity.HouseRefUser
     */
    HouseRefUser selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:50
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseRefUser record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:51
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseRefUser record);
    /**
     * 根据用户id查询用户所有的出租房源信息
     * @Auther sunshuai
     * @Date 2020/9/23 19:36
     * @param id userId
     * @return java.util.List<com.zlk.group4.vo.HouseMsg>
     */
    List<HouseMsg>  listAllByUserId(Integer id);

    /**
     * 根据userId查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:51
     * @param id
     * @return java.util.List<com.zlk.group4.house.entity.HouseRefUser>
     */
    List<HouseRefUser> selectHouseByUserId(Integer id);

    /**
     * 根据房源信息id删除用户出租房源信息
     * @Auther sunshuai
     * @Date 2020/9/23 19:39
     * @param id houseMsgId
     * @return int 受影响行数
     */
    int deleteHouseMsg(Integer uid,Integer id);

    /**
     * 根据HouseMsg修改房源信息
     * @Auther sunshuai
     * @Date 2020/9/24 9:03
     * @param houseMsg
     * @return int
     */
    int updateByHouseMsg(HouseMsg houseMsg);

    /**
     * 根据houseMsg增加房源信息并返回新增houseId
     * @Auther sunshuai
     * @Date 2020/9/25 10:36
     * @param houseMsg
     * @return int 新增houseId
     */
    int insertHouseMsg(HouseMsg houseMsg,Integer userId);

    /**
     * 根据houseId查询所有信息
     * @Auther sunshuai
     * @Date 2020/9/28 16:52
     * @param houseId
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> listAllByHouseId(Integer houseId);
    /**
     *
     * 通过房屋id查询用户
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/27 14:15
     */
    HouseRefUser selectUserByHouseId(Integer id);


    /**
     * 根据userId查询houseId
     * @Auther lihongying
     * @Date 2020/10/8 17:08
     * @param id
     * @return List
     */
    List<Integer> selectHouseIdByUserId(Integer id);


}


