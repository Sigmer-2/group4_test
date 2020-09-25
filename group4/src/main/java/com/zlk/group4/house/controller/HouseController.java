package com.zlk.group4.house.controller;

import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有关房屋信息的操作
 * @author: zhc
 * @time: 2020/9/23 17:45
 */
@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;


    @RequestMapping(value = "/adminFindAllHouse")
    @ResponseBody
    public Map<String, Object> findCOrderAll(Integer page, Integer limit) throws Exception{
        Map<String,Object> paraMap = new HashMap<String,Object>();
        List<House> houseList = houseService.adminManageHouse(paraMap,page,limit);
        Integer count = houseService.findHouseCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg","");
        map.put("data", houseList);
        map.put("count", count);
        return map;
    }

}
