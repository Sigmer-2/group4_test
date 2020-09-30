package com.zlk.group4.repair.service;

import com.zlk.group4.repair.entity.WxRepair;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: lihongying
 * Date: 2020-09-27
 * Time: 21:42
 */
public interface WxRepairsService {

/**
 * 增加报修数据
 * @Auther lihongying
 * @Date 2020/9/27 21:45
 * @param record
 * @return int
 */
    int insertRepairs(WxRepair record);
/**
 * 根据用户id查询用户所有的报修信息
 * @Auther lihongying
 * @Date 2020/9/27 21:47
 * @param repairUserid
 * @return com.zlk.group4.repair.entity.Repairs
 */
    WxRepair findRepairsByUserid(Integer repairUserid);
    /**
     * 根据用户id查询用户所有的报修信息和小区位置
     * @Auther lihongying
     * @Date 2020/9/28 11:50
     * @param repairUserid
     * @return java.util.List<com.zlk.group4.repair.entity.WxRepair>
     */
    List<WxRepair> selectLocationByUserId(Integer repairUserid);
}
