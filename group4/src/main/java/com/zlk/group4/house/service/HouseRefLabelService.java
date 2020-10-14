package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseRefLabel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefLabelService {


    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:52
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部值
     * @Auther sunshuai
     * @Date 2020/10/14 9:52
     * @param record
     * @return int
     */
    int insert(HouseRefLabel record);

    /**
     * 插入全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:52
     * @param record
     * @return int
     */
    int insertSelective(HouseRefLabel record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:53
     * @param id
     * @return com.zlk.group4.house.entity.HouseRefLabel
     */
    HouseRefLabel selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:53
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseRefLabel record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:53
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseRefLabel record);

    /**
     * @Description:根据房源id获取房间标签信息
     * @Auther sunshuai
     * @Date 2020/9/23 14:45
     * @param id houseid
     * @return java.util.List<com.zlk.group4.house.entity.HouseRefLabel>
     */
    HouseRefLabel selectLabelByHouseId(Integer id);

    /**
     * 根据表数据生成label字符串
     * @Auther sunshuai
     * @Date 2020/10/14 9:54
     * @param id
     * @return java.lang.String
     */
    String label(Integer id);
    /**
     * 根据houseId查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:56
     * @param id
     * @return int
     */
    int findHouseLabelIdByHouseId(Integer id);

}


