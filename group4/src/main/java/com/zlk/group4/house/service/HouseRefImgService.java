package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseRefImg;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

public interface HouseRefImgService {


    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:56
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部值
     * @Auther sunshuai
     * @Date 2020/10/14 9:57
     * @param record
     * @return int
     */
    int insert(HouseRefImg record);

    /**
     * 插入全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:57
     * @param record
     * @return int
     */
    int insertSelective(HouseRefImg record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:57
     * @param id
     * @return com.zlk.group4.house.entity.HouseRefImg
     */
    HouseRefImg selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:57
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseRefImg record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:58
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseRefImg record);

    /**
     * 根据id查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:58
     * @param id
     * @return java.util.List<com.zlk.group4.house.entity.HouseRefImg>
     */
    List<HouseRefImg> selectImgByHouseId(Integer id);


}


