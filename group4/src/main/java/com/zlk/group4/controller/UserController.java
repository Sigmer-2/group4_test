package com.zlk.group4.controller;

import com.zlk.group4.entity.Street;
import com.zlk.group4.entity.User;
import com.zlk.group4.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.zlk.group4.util.MD5Utils.md5Encrypt32Lower;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zhc
 * @time: 2020/9/22 10:20
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody User user) throws Exception {//登陆
//        System.out.println(user.toString());
        Map<String, Object> map = new HashMap<>();
//        user.setUserPassword(md5Encrypt32Lower(user.getUserPassword()));
//        Integer flag = userService.selectUserLogin(user);
//        System.out.println(flag);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
        // 执行认证登陆
        subject.login(token);
        user.setUserPassword(md5Encrypt32Lower(user.getUserPassword()));
        Integer roleid = userService.findUserRole(user);
        if (subject.isAuthenticated()) {
            map.put("status", 1);
            if(roleid!=null){
                if(roleid==2){
                    map.put("type",2);
                }else{
                    map.put("type",1);
                }
            }
            else{
                map.put("type",1);
            }
        } else {
            token.clear();
            map.put("status", 0);
        }
        return map;
//        if (flag == 1) {
//            map.put("status", 1);
//            System.out.println(map.get("status"));
//            if(roleid!=null){
//                if(roleid==2){
//                    map.put("type",2);
//                }else{
//                    map.put("type",1);
//                }
//            }
//            else{
//                map.put("type",1);
//            }
//            return map;
//        } else {
//            map.put("status", 0);
//        }
//
//        return map;
    }


    /**注册*/
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(@RequestBody User user) {//注册
        System.out.println(user.toString());
        Map<String, Object> map = new HashMap<>();
        //先查询数据库内有无此用户名
        Integer flag1 = userService.selectUserByName(user.getUserName());
        System.out.println(flag1);
        if (flag1 > 0) {
            map.put("status", -1);
            return map;
        }
        //md5加密
        user.setUserPassword(md5Encrypt32Lower(user.getUserPassword()));
        Integer flag = userService.saveUser(user);
        if (flag > 0) {
            map.put("status", 1);
        } else {
            map.put("status", 0);
        }
        return map;
    }
    //退出登录
    /*@RequestMapping("/logout")
    public String shiroLogout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }*/

    @RequestMapping("/loginUser")
    @ResponseBody
    public User sysUserTest(){
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        User sysUser = userService.selectUserByName1(principal);
        return sysUser;
    }
    /**
     *
     * 插入用户浏览足迹
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/10/13 11:23
     */
    @RequestMapping(value = "/insertFoot", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> insertFoot(Integer userId,Integer houseId) throws Exception {
        Date dateNow = new Date();
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("userId",userId);
        map1.put("houseId",houseId);
        map1.put("dateNow",dateNow);
        Integer flag = userService.insertFoot(map1);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", flag);
        return map;
    }

}

