package com.zlk.group4.repair.controller;

import com.zlk.group4.repair.entity.WxRepair;
import com.zlk.group4.repair.service.WxRepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lihongying
 * Date: 2020-09-28
 * Time: 11:33
 */
@Controller
public class WxRepairController {
    @Autowired
    private WxRepairsService wxRepairsService;
    
    @ResponseBody
    @RequestMapping(value = "/findRepairAll",method = RequestMethod.GET)
    public Map<String,Object> findRepairAll(Integer repairUserid) throws Exception{
        List<WxRepair> repairList = wxRepairsService.selectLocationByUserId(repairUserid);
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",repairList);
        return map;
    }
}
