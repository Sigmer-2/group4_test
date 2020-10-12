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


    int deleteByPrimaryKey(Integer id);

    int insert(HouseRefLabel record);

    int insertSelective(HouseRefLabel record);

    HouseRefLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseRefLabel record);

    int updateByPrimaryKey(HouseRefLabel record);

    /**
     * @Description:根据房源id获取房间标签信息
     * @Auther sunshuai
     * @Date 2020/9/23 14:45
     * @param id houseid
     * @return java.util.List<com.zlk.group4.house.entity.HouseRefLabel>
     */
    HouseRefLabel selectLabelByHouseId(Integer id);

    String label(Integer id);

    int findHouseLabelIdByHouseId(Integer id);

}


