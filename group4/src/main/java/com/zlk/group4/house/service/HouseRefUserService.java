package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseRefUser;
import com.zlk.group4.vo.HouseMsg;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefUserService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseRefUser record);

    int insertSelective(HouseRefUser record);

    HouseRefUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRefUser record);

    int updateByPrimaryKey(HouseRefUser record);
    /**
     * 根据用户id查询用户所有的出租房源信息
     * @Auther sunshuai
     * @Date 2020/9/23 19:36
     * @param id userId
     * @return java.util.List<com.zlk.group4.vo.HouseMsg>
     */
    List<HouseMsg> listAllByUserId(Integer id);

    List<HouseRefUser> selectHouseByUserId(Integer id);

    /**
     * 根据房源信息id删除用户出租房源信息
     * @Auther sunshuai
     * @Date 2020/9/23 19:39
     * @param id houseMsgId
     * @return int 受影响行数
     */
    int deleteHouseMsg(Integer id);

    /**
     * 根据HouseMsg修改房源信息
     * @Auther sunshuai
     * @Date 2020/9/24 9:03
     * @param houseMsg
     * @return int
     */
    int updateByHouseMsg(HouseMsg houseMsg);



}


