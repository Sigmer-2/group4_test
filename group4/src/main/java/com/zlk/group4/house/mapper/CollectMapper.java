package com.zlk.group4.house.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.zlk.group4.house.entity.Collect;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: sunshuai
 * Date: 2020-10-12
 * Time: 13:38
 */
    
@Mapper
public interface CollectMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Collect record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Collect record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Collect selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Collect record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Collect record);

    Collect findAllByCollectUseridAndCollectHouseid(@Param("collectUserid")Integer collectUserid,@Param("collectHouseid")Integer collectHouseid);

    int deleteByCollectUseridAndCollectHouseid(@Param("collectUserid")Integer collectUserid,@Param("collectHouseid")Integer collectHouseid);




}