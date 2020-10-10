package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseLabel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseLabelService {


    int deleteByPrimaryKey(Integer id);

    int insert(HouseLabel record);

    int insertSelective(HouseLabel record);

    HouseLabel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseLabel record);

    int updateByPrimaryKey(HouseLabel record);

    /**
     * 根据标签字符串更新HouseLabel内容
     * @Auther sunshuai
     * @Date 2020/9/23 22:06
     * @param str
     * @return int
     */
    int updateByString(String str);

    /**
     * 根据标签字符串新增HouseLabel内容
     * @Auther sunshuai
     * @Date 2020/9/25 13:51
     * @param str
     * @return int 新增houseLabelId
     */
    int insertHouseLabelByString(String str);

}


