package com.zlk.group4.repair.controller;

import com.zlk.group4.repair.entity.Repair;
import com.zlk.group4.repair.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/repairMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> repairMessage(Integer page,Integer limit) throws Exception{//查询所有报修信息
        Integer count = repairService.findRepairCount();
        List<Repair> repairList = repairService.findAllRepair(page, limit);
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",repairList);
        map.put("count",count);
        return map;
    }
    @RequestMapping(value = "/updateRepair/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateRepair(@PathVariable("id") Integer id) throws Exception{//更新审核状态
        Integer flag = repairService.updateRepairById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("status",flag);
        return map;
    }
    @RequestMapping(value = "/selectRepairBy",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> selectRepairBy(Integer select,String data) throws Exception{//条件查询
        if(select == null){
            select = 0;
        }
        Map<String, Object> map = new HashMap<>();
        if(select == 0){
            List<Repair> repairList = repairService.selectRepairByUser(data);
            map.put("code",0);
            map.put("msg","");
            map.put("data",repairList);
        }else if(select == 1){
            List<Repair> repairList = repairService.selectRepairByHouse(data);
            map.put("code",0);
            map.put("msg","");
            map.put("data",repairList);
        }
        return map;
    }

}
