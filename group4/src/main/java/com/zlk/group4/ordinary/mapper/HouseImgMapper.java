package com.zlk.group4.ordinary.mapper;

import com.zlk.group4.ordinary.entity.HouseImg;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 房间照片
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface HouseImgMapper {

    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:05
     * @param id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 16:05
     * @param record the record
     * @return int insert count
     */
    int insert(HouseImg record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:06
     * @param record the record
     * @return int insert count
     */
    int insertSelective(HouseImg record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:07
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.HouseImg
     */
    HouseImg selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:08
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(HouseImg record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 16:08
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(HouseImg record);
}