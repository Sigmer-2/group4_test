package com.zlk.group4.repair.service.impl;

import com.zlk.group4.repair.entity.Repair;
import com.zlk.group4.repair.mapper.RepairMapper;
import com.zlk.group4.repair.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RepairServiceImpl
 * @program: group4
 * @description: 报修功能service层接口实现类
 * @author: wujian
 * @Date: 2020/9/24 11:22
 **/
@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairMapper repairMapper;
    @Override
    public List<Repair> findAllRepair(Integer page, Integer limit) {
        Integer startIndex = (page-1)*limit;
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("startIndex",startIndex);
        paraMap.put("pageSize",limit);
        return repairMapper.findAllRepair(paraMap);
    }

    @Override
    public Integer findRepairCount() {
        return repairMapper.findRepairCount();
    }

    @Override
    public Integer updateRepairById(Integer id) {
        return repairMapper.updateRepairById(id);
    }
}
