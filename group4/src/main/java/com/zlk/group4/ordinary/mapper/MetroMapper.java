package com.zlk.group4.ordinary.mapper;

import com.zlk.group4.ordinary.entity.Metro;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 地铁
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:45
 */
    
@Mapper
public interface MetroMapper {

    /**
     * @Description: delete by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 17:02
     * @param id primaryKey
     * @return int deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @Description: insert record to table
     * @Auther sunshuai
     * @Date 2020/9/22 17:02
     * @param record the record
     * @return int insert count
     */
    int insert(Metro record);

    /**
     * @Description: insert record to table selective
     * @Auther sunshuai
     * @Date 2020/9/22 17:03
     * @param record the record
     * @return int insert count
     */
    int insertSelective(Metro record);

    /**
     * @Description: select by primary key
     * @Auther sunshuai
     * @Date 2020/9/22 17:03
     * @param id primary key
     * @return com.zlk.group4.ordinary.entity.Metro
     */
    Metro selectByPrimaryKey(Integer id);

    /**
     * @Description: update record selective
     * @Auther sunshuai
     * @Date 2020/9/22 17:04
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKeySelective(Metro record);

    /**
     * @Description: update record
     * @Auther sunshuai
     * @Date 2020/9/22 17:04
     * @param record the updated record
     * @return int update count
     */
    int updateByPrimaryKey(Metro record);
}