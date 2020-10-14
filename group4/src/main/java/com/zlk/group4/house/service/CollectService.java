package com.zlk.group4.house.service;

import com.zlk.group4.house.entity.Collect;
    /**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: sunshuai
 * Date: 2020-10-12
 * Time: 13:38
 */
    
public interface CollectService{


    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 10:03
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 10:03
     * @param record
     * @return int
     */
    int insert(Collect record);

    /**
     * 插入全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 10:03
     * @param record
     * @return int
     */
    int insertSelective(Collect record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 10:04
     * @param id
     * @return com.zlk.group4.house.entity.Collect
     */
    Collect selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 10:04
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(Collect record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 10:04
     * @param record
     * @return int
     */
    int updateByPrimaryKey(Collect record);

    /**
     * 根据userId，houseId查询
     * @Auther sunshuai
     * @Date 2020/10/14 10:04
     * @param uid
     * @param hid
     * @return com.zlk.group4.house.entity.Collect
     */
    Collect findAllByCollectUseridAndCollectHouseid(Integer uid,Integer hid);

    /**
     * 根据userId，houseId删除
     * @Auther sunshuai
     * @Date 2020/10/14 10:05
     * @param uid
     * @param hid
     * @return int
     */
    int deleteByCollectUseridAndCollectHouseid(Integer uid,Integer hid);

}
