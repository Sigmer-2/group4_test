package com.zlk.group4.repair.service;

import com.zlk.group4.repair.entity.Repair;

import java.util.List;

/**
 * @ClassName RepairService
 * @program: group4
 * @description: 报修功能service层接口
 * @author: wujian
 * @Date: 2020/9/24 11:19
 **/
public interface RepairService {
    /**
     *查询所有报修记录
     * @author: wujian
     * @Date: 2020/10/1 15:04
     * @PARAM:[page, limit]
     * @return: java.util.List<com.zlk.group4.repair.entity.Repair>
     */
    List<Repair> findAllRepair(Integer page, Integer limit);
    /**
     *查询报修记录数量
     * @author: wujian
     * @Date: 2020/10/1 15:05
     * @PARAM:[]
     * @return: java.lang.Integer
     */
    Integer findRepairCount();
    /**
     *更新报修审核状态
     * @author: wujian
     * @Date: 2020/10/1 15:05
     * @PARAM:[id]
     * @return: java.lang.Integer
     */
    Integer updateRepairById(Integer id);
    /**
     *通过用户查询报修记录
     * @author: wujian
     * @Date: 2020/10/1 15:06
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.repair.entity.Repair>
     */
    List<Repair> selectRepairByUser(String data);
    /**
     *通过房屋查询报修记录
     * @author: wujian
     * @Date: 2020/10/1 15:06
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.repair.entity.Repair>
     */
    List<Repair> selectRepairByHouse(String data);
}
