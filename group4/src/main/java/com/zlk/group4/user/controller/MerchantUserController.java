package com.zlk.group4.user.controller;

import com.zlk.group4.repair.entity.WxRepair;
import com.zlk.group4.user.entity.MerchantUser;
import com.zlk.group4.user.entity.UserPage;
import com.zlk.group4.user.service.MerchantUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
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
    private int addMerchantUser(@RequestBody MerchantUser merchantUser){
        int flag =  merchantUserService.insertSelectiveMerchant(merchantUser);
        return flag;
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
