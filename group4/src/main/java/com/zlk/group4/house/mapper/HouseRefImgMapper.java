package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseRefImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 14:16
 */

@Mapper
public interface HouseRefImgMapper {
    /**
     * 根据主键删除
     * @Auther sunshuai
     * @Date 2020/10/14 9:20
     * @param id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入全部字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:20
     * @param record
     * @return int
     */
    int insert(HouseRefImg record);

    /**
     * 插入全部不为null的字段
     * @Auther sunshuai
     * @Date 2020/10/14 9:20
     * @param record
     * @return int
     */
    int insertSelective(HouseRefImg record);

    /**
     * 根据主键查询
     * @Auther sunshuai
     * @Date 2020/10/14 9:21
     * @param id
     * @return com.zlk.group4.house.entity.HouseRefImg
     */
    HouseRefImg selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新属性不为null的值
     * @Auther sunshuai
     * @Date 2020/10/14 9:21
     * @param record
     * @return int
     */
    int updateByPrimaryKeySelective(HouseRefImg record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @Auther sunshuai
     * @Date 2020/10/14 9:22
     * @param record
     * @return int
     */
    int updateByPrimaryKey(HouseRefImg record);

    /**
     * @Description:根据houseid查询房间照片
     * @Auther sunshuai
     * @Date 2020/9/23 17:36
     * @param id houseid
     * @return java.util.List<com.zlk.group4.house.entity.HouseRefImg>
     */
    List<HouseRefImg> selectImgByHouseId(Integer id);
}