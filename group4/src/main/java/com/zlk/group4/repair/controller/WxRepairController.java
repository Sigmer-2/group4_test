package com.zlk.group4.repair.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlk.group4.house.entity.HouseRefUser;
import com.zlk.group4.house.service.HouseRefUserService;
import com.zlk.group4.repair.entity.WxRepair;
import com.zlk.group4.repair.service.WxRepairsService;
import com.zlk.group4.util.MyHouseUtils;
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
    /**
     * 根据userId查询所以维修信息
     * @Auther lihongying
     * @Date 2020/10/8 16:55
     * @param request
    * @param response
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @ResponseBody
    @RequestMapping(value = "/findRepairAll",method = RequestMethod.POST)
    public Map<String,Object> findRepairAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, Object> map = new HashMap<>();
        JSONObject result = MyHouseUtils.getResult(request);
        String userId = result.getString("userId");
        System.out.println(userId);
        if (!"".equals(userId)){
            List list = wxRepairsService.selectLocationByUserId(Integer.parseInt(userId));
            map.put("code", 0);
            map.put("list", list);
        }
//        Integer userId = 3;
//        List<WxRepair> list = wxRepairsService.findRepairsByUserid(userId);
//        List<WxRepair> list = wxRepairsService.selectLocationByUserId(userId);
//        map.put("list", list);
        return map;
    }
    /**
     * 添加报修信息
     * @Auther lihongying
     * @Date 2020/10/8 16:55
     * @param request
     * @param response
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
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
    /**
     * 根据userId查询该用户所以房源id
     * @Auther lihongying
     * @Date 2020/10/8 16:55
     * @param request
     * @param response
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @ResponseBody
    @RequestMapping(value = "/findHouseId",method = RequestMethod.POST)
    public Map<String,Object> findHouseId(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, Object> map = new HashMap<>();
        JSONObject result = MyHouseUtils.getResult(request);
        String userId = result.getString("userId");
        System.out.println(userId);
        if (!"".equals(userId)){
            List list = houseRefUserService.selectHouseIdByUserId(Integer.parseInt(userId));
            map.put("code", 0);
            map.put("list", list);
        }

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
//        Integer userId = 3;
        return map;
    }
}
