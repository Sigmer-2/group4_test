package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseRefLabel;
import org.apache.ibatis.annotations.Mapper;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface HouseRefLabelMapper {
    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:18
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:18
     * @param record
     * @return int
     */
    int insert(HouseRefLabel record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:19
     * @param record
     * @return int
     */
    int insertSelective(HouseRefLabel record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:19
     * @param id
     * @return com.zlk.group4.house.entity.HouseRefLabel
     */
    HouseRefLabel selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新全部不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:19
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseRefLabel record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:20
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
     * 查找houseLabelId
     * @Auther sunshuai
     * @Date 2020/10/12 10:28
     * @param id
     * @return int
     */
    int findHouseLabelIdByHouseId(Integer id);
}