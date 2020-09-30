package com.zlk.group4.person.mapper;

import com.zlk.group4.area.entity.Area;
import com.zlk.group4.area.entity.Street;
import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.entity.HouseDeploy;
import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseLabel;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author sunjiahe
 */
@Mapper
public interface PersonMapper {
     /**
      * @description:在user表中根据id查找用户名
      * @author: sunjiahe
      * @param: [id]
      * @return: java.lang.String
      * @date: 2020/9/27 20:42
      **/
     String findUserName(Integer id);
     /**
      *
      * @describetion:在user表中根据id查找用户头像
      * @author:sunjiahe
      * @date:2020/9/30 0:09
      * @param:[id]
      * @return:java.lang.String
      */
     String findUserImg(Integer id);
     /**
      * @describetion:添加租房信息
      * @author:sunjiahe
      * @date:2020/9/30 0:10
      * @param:[house]
      * @return:java.lang.Integer
      */
     Integer saveHouse(House house);
     /**
      * @describetion:添加房间照片信息
      * @author:sunjiahe
      * @date:2020/9/30 0:11
      * @param:[houseImg]
      * @return:java.lang.Integer
      */
     Integer saveHouseImg(HouseImg houseImg);
     /**
      * @describetion:添加房源标签信息
      * @author:sunjiahe
      * @date:2020/9/30 0:14
      * @param:[houseLabel]
      * @return:java.lang.Integer
      */
     Integer saveHouseLabel(HouseLabel houseLabel);
     /**
      * @describetion:添加房源部署信息
      * @author:sunjiahe
      * @date:2020/9/30 0:14
      * @param:[houseDeploy]
      * @return:java.lang.Integer
      */
     Integer saveHouseDeploy(HouseDeploy houseDeploy);
     /**
      * @describetion:查找长春所有区域的编号和名字
      * @author:sunjiahe
      * @date:2020/9/30 0:15
      * @param:[]
      * @return:java.util.List
      */
     List<Area> findChangChunAreaAll(Map map);
     /**
      * @describetion:查询changchun_area表的行数
      * @author:sunjiahe
      * @date:2020/9/30 9:09
      * @param:[]
      * @return:java.lang.Integer
      */
     Integer findChangChunAreaCount();
     /**
      * @describetion:查询对应区域id的全部街道
      * @author:sunjiahe
      * @date:2020/9/30 0:16
      * @param:[id]
      * @return:java.lang.Integer
      */
     List<Street> findStreetByAreaId(Map map);
     /**
      * @describetion:查询对应id的街道所在行
      * @author:sunjiahe
      * @date:2020/9/30 9:57
      * @param:[]
      * @return:java.lang.Integer
      */
     Integer findChangChunStreetCount(Integer id);




}
