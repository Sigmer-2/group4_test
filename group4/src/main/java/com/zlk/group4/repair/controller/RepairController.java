package com.zlk.group4.repair.controller;

import com.zlk.group4.repair.entity.Repair;
import com.zlk.group4.repair.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RepairController
 * @program: group4
 * @description: 报修功能controller层
 * @author: wujian
 * @Date: 2020/9/24 11:29
 **/
@Controller
@RequestMapping("/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;
    @RequestMapping("/repairMessage")
    @ResponseBody
    public Map<String,Object> repairMessage(Integer page,Integer limit) throws Exception{
        Integer count = repairService.findRepairCount();
        List<Repair> repairList = repairService.findAllRepair(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",repairList);
        map.put("count",count);
        return map;
    }
    @RequestMapping("/updateRepair/{id}")
    @ResponseBody
    public Map<String,Object> updateRepair(@PathVariable("id") Integer id) throws Exception{
        Integer flag = repairService.updateRepairById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("status",flag);
        return map;
    }

}
