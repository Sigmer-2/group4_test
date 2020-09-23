package com.zlk.group4.house.mapper;

import com.zlk.group4.house.entity.HouseRefImg;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 房源照片
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface HouseRefImgMapper {

    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:29
     * @param id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 16:29
     * @param record the record
     * @return int insert count
     */
    int insert(HouseRefImg record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:30
     * @param record the record
     * @return int insert count
     */
    int insertSelective(HouseRefImg record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 16:30
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.HouseRefImg
     */
    HouseRefImg selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 16:31
     * @param record record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(HouseRefImg record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 16:31
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(HouseRefImg record);
}