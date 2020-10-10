package com.zlk.group4.repair.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlk.group4.house.entity.HouseRefUser;
import com.zlk.group4.house.service.HouseRefUserService;
import com.zlk.group4.repair.entity.WxRepair;
import com.zlk.group4.repair.service.WxRepairsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
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

    @Autowired
    private HouseRefUserService houseRefUserService;
    
    @ResponseBody
    @RequestMapping(value = "/findRepairAll",method = RequestMethod.GET)
    public Map<String,Object> findRepairAll(Integer repairUserid) throws Exception{
        Map<String, Object> map = new HashMap<>();
        Integer userId = 3;
//        List<WxRepair> list = wxRepairsService.findRepairsByUserid(userId);
        List<WxRepair> list = wxRepairsService.selectLocationByUserId(userId);
        map.put("list", list);
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/insertRepair",method = RequestMethod.POST)
    public Map<String,Object> insertRepair(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, Object> map = new HashMap<>();
        // java端:通过参数HttpServletRequest request解析出json格式的参数
        // json包用的阿里的 com.alibaba.fastjson.JSONObject;
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        WxRepair wxRepair = new WxRepair();
        Integer userId = 3;
        wxRepair.setRepairUserid(userId);
        String houseId = result.getString("houseId");
        if (!"".equals(houseId)){
            wxRepair.setRepairHouseid(Integer.parseInt(houseId));
        }
        wxRepair.setRepairDescribe(result.getString("describe"));
        wxRepair.setRepairStatus(0);
        int i = wxRepairsService.insertRepairs(wxRepair);
        if (i==1){
            map.put("status",0);
        }else {
            map.put("status", 1);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/findHouseId",method = RequestMethod.GET)
    public Map<String,Object> findHouseId(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, Object> map = new HashMap<>();
        // java端:通过参数HttpServletRequest request解析出json格式的参数
        // json包用的阿里的 com.alibaba.fastjson.JSONObject;
        /*JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Integer userId = 3;
        List list = houseRefUserService.selectHouseIdByUserId(userId);
        map.put("code", 0);
        map.put("list", list);
        return map;
    }
}
