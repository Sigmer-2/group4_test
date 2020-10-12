package com.zlk.group4.repair.mapper;

import com.zlk.group4.house.entity.HouseRefUser;
import com.zlk.group4.repair.entity.WxRepair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: lihongying
 * Date: 2020-09-27
 * Time: 21:42
 */
@Mapper
public interface WxRepairsMapper {
    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertRepairs(WxRepair record);

    /**
     * 根据用户id查询用户所有的报修信息
     * @Auther lihongying
     * @Date 2020/9/28 11:51
     * @param repairUserid
     * @return java.util.List<com.zlk.group4.repair.entity.WxRepair>
     */
    List<WxRepair> findRepairsByUserid(Integer repairUserid);
    /**
    * 根据用户id查询用户所有的报修信息和小区位置
    * @Auther lihongying
    * @Date 2020/9/28 11:51
    * @param repairUserid
    * @return java.util.List<com.zlk.group4.repair.entity.WxRepair>
     */
    List<WxRepair> selectLocationByUserId(Integer repairUserid);
}