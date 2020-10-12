package com.zlk.group4.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlk.group4.user.entity.MerchantUser;
import com.zlk.group4.user.service.MerchantUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:商家入驻
 * User: lihongying
 * Date: 2020-09-27
 * Time: 19:00
 */
@Controller
public class MerchantUserController {
    @Autowired
    private MerchantUserService merchantUserService;
    @ResponseBody
    @RequestMapping(value = "/insertMerchantUser",method = RequestMethod.POST)
    private Map<String,Object> addMerchantUser(HttpServletRequest request, HttpServletResponse response){
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
        MerchantUser merchantUser =new MerchantUser();
        merchantUser.setType(result.getString("type"));
        merchantUser.setUserName(result.getString("userName"));
        merchantUser.setTel(result.getString("tel"));
        merchantUser.setUserPlace(result.getString("userPlace"));
        merchantUser.setBusinessName(result.getString("businessName"));
        String houseNumber = result.getString("houseNumber");
        if (!"".equals(houseNumber)){
            merchantUser.setHouseNumber(Integer.parseInt(houseNumber));
        }
        int i = merchantUserService.insertSelectiveMerchant(merchantUser);
        if (i==1){
            map.put("status",0);
        }else {
            map.put("status", 1);
        }
        return map;
    }


    @ResponseBody
    @RequestMapping(value = "/findMerchantUserAll",method = RequestMethod.GET)
    public Map<String,Object> findMerchantUserAll(Integer id) throws Exception{
        List<MerchantUser> merchantUserList = merchantUserService.selectMerchantUser(id);
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",merchantUserList);
        return map;
    }
}
