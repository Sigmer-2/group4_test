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
    List<Repair> findAllRepair(Integer page, Integer limit);
    Integer findRepairCount();
    Integer updateRepairById(Integer id);
}
