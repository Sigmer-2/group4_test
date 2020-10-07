package com.zlk.group4.user.controller;

import com.zlk.group4.user.entity.Role;
import com.zlk.group4.user.entity.UserPage;
import com.zlk.group4.user.mapper.RoleMapper;
import com.zlk.group4.user.service.RoleService;
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
public class RoleController {

    @Autowired(required = false)
    private RoleService roleService;


    @RequestMapping(value = "/role")
    public String role() throws Exception{
        return "/admin/role";
    }

    @ResponseBody
    @RequestMapping(value = "/roleManager",method = RequestMethod.GET)
    public Map<String,Object> roleManager(Integer page, Integer limit){
        List<Role> roleList = roleService.findRoleList(page,limit);
        Integer roleCount = roleService.findRoleCount();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",roleList);
        map.put("count",roleCount);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/saveRole",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestBody Role role){
        Integer flag = roleService.saveRole(role);
        Map<String,Object> map = new HashMap<String, Object>();
        if(flag > 0){
            map.put("status",1);
        }else{
            map.put("status",0);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRole/{id}",method = RequestMethod.DELETE)
    public Map<String,Object> deleteById(@PathVariable("id") int id){
        int result = roleService.deleteRoleById(id);
        Map<String,Object> map = new HashMap<String, Object>();
        if(result >0){
            map.put("status",1);
        }else{
            map.put("status",0);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateRole",method = RequestMethod.PUT)
    public Map<String,Object> update(@RequestBody Role role){
        int result = roleService.updateRoleById(role);
        Map<String,Object> map = new HashMap<String, Object>();
        if(result > 0){
            map.put("status",1);
        }else{
            map.put("status",0);
        }
        return  map;
    }

    @ResponseBody
    @RequestMapping(value = "/findRoleListById",method = RequestMethod.GET)
    public Map<String,Object> findRoleListById(Integer id){
        List<Role> roleList = roleService.findRoleListById(id);
        Integer count = roleService.findRoleListByIdCount(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("data",roleList);
        map.put("count",count);
        return map;
    }


}
