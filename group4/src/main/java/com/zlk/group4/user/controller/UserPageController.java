package com.zlk.group4.user.controller;

import com.zlk.group4.user.entity.Role;
import com.zlk.group4.user.entity.UserPage;
import com.zlk.group4.user.service.UserPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:sunjiahe
 * @date:2020/9/23
 * @descreption:
 */
@Controller
public class UserPageController {
     @Autowired(required = false)
     private UserPageService userPageService;

     @RequestMapping(value = "/user")
     public String user() throws Exception{
             return "/admin/user";
     }


    @ResponseBody
    @RequestMapping(value = "/userManager")
    public Map<String,Object> userManager(Integer page,Integer limit){
        List<UserPage> userList = userPageService.findUserList(page,limit);
        Integer userCount = userPageService.findUserCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",userList);
        map.put("count",userCount);
        return map;
    }

     @ResponseBody
     @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
     public Map<String,Object> add(@RequestBody UserPage user){
         Integer flag = userPageService.saveUser0(user);
         Map<String,Object> map = new HashMap<String, Object>();
         if(flag > 0){
             map.put("status",1);
         }else{
             map.put("status",0);
         }
         return map;
     }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> deleteById(@PathVariable("id") int id){
         int result = userPageService.deleteUserById(id);
         Map<String,Object> map = new HashMap<String, Object>();
         if(result >0){
             map.put("status",1);
         }else{
             map.put("status",0);
         }
         return map;
     }

     @ResponseBody
     @RequestMapping(value = "",method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody UserPage user){
         int result = userPageService.updateUserById(user);
         Map<String,Object> map = new HashMap<String, Object>();
         if(result > 0){
             map.put("status",1);
         }else{
             map.put("status",0);
         }
         return  map;
     }

    @ResponseBody
    @RequestMapping("/findUserListById")
    public Map<String,Object> findUserListById(Integer id){
         List<UserPage> userList = userPageService.findUserListById(id);
         Integer count = userPageService.findUserListByIdCount(id);
         Map<String,Object> map = new HashMap<String, Object>();
         map.put("code",0);
         map.put("data",userList);
         map.put("count",count);
         return map;
     }

    @RequestMapping("/findRoleIdAndName")
    @ResponseBody
    public List<Role> findRoleIdAndName(){
        try {
            List<Role> roleList = userPageService.findRoleIdAndName();
            return roleList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
