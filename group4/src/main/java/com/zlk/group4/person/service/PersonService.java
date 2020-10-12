package com.zlk.group4.person.service;

import com.zlk.group4.area.entity.Area;
import com.zlk.group4.area.entity.Street;
import com.zlk.group4.entity.User;
import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.entity.HouseDeploy;
import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseLabel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public interface PersonService {
    /**
     * @description:在user表中根据id查找用户名
     * @author: sunjiahe
     * @param: [id]
     * @return: java.lang.String
     * @date: 2020/9/27 20:43
     **/
    String findUserName(Integer id);
    /**
     * @describetion:在user表中根据id查找用户头像
     * @author:sunjiahe
     * @date:2020/9/30 0:30
     * @param:[id]
     * @return:java.lang.String
     */
    String findUserImg(Integer id);
    /**
     * @describetion:添加房源信息（我要招租页面）
     * @author:sunjiahe
     * @date:2020/9/30 0:30
     * @param:[house, houseImg, houseLabel, houseDeploy]
     * @return:java.lang.Integer
     */
    Integer insertAll(House house,HouseImg houseImg,HouseLabel houseLabel,HouseDeploy houseDeploy);
    /**
     * @describetion:查找长春所有区域的编号和名字
     * @author:sunjiahe
     * @date:2020/9/30 0:31
     * @param:[]
     * @return:java.util.List<com.zlk.group4.area.entity.Area>
     */
    public List<Area> findChangChunAreaAll(Integer page,Integer limit);
    /**
     * @describetion:查询changchun_area表的行数
     * @author:sunjiahe
     * @date:2020/9/30 9:15
     * @param:[]
     * @return:java.lang.Integer
     */
    Integer findChangChunAreaCount();
    /**
     * @describetion:查询对应区域id的全部街道
     * @author:sunjiahe
     * @date:2020/9/30 0:32
     * @param:[id]
     * @return:java.util.List<com.zlk.group4.area.entity.Street>
     */
    List<Street> findStreetByAreaId(Integer page,Integer limit,Integer id);
    /**
     * @describetion:查询对应id的街道所在行
     * @author:sunjiahe
     * @date:2020/9/30 9:59
     * @param:[]
     * @return:java.lang.Integer
     */
    Integer findChangChunStreetCount(Integer id);
    /**
     * @describetion:根据openId查询用户信息
     * @author:sunjiahe
     * @date:2020/10/5 8:02
     * @param:[id]
     * @return:com.zlk.group4.entity.User
     */
    User findUserByOpenId(String openId);
    /**
     * @describetion:根据用户id更新sessionKey
     * @author:sunjiahe
     * @date:2020/10/5 10:17
     * @param:[openId]
     * @return:java.lang.Integer
     */
    Integer updateSessionKey(Integer id,String sessionKey);
    /**
     * @describetion:添加用户信息
     * @author:sunjiahe
     * @date:2020/10/6 14:59
     * @param:[user]
     * @return:java.lang.Integer
     */
    Integer insertUserInformation(User user);
    /**
     * @describetion:根据用户id修改用户信息
     * @author:sunjiahe
     * @date:2020/10/12 17:09
     * @param:[user]
     * @return:java.lang.Integer
     */
    Integer updateUserById(User user);




}
