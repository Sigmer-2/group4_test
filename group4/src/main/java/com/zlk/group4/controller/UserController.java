package com.zlk.group4.controller;

import com.zlk.group4.entity.User;
import com.zlk.group4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static com.zlk.group4.util.MD5Utils.md5Encrypt32Lower;
import java.util.HashMap;
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
        System.out.println(user.toString());
        Map<String, Object> map = new HashMap<>();
        user.setUserPassword(md5Encrypt32Lower(user.getUserPassword()));
        Integer flag = userService.selectUserLogin(user);
        System.out.println(flag);
        Integer roleid = userService.findUserRole(user);
        if (flag == 1) {
            map.put("status", 1);
            System.out.println(map.get("status"));
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
            return map;
        } else {
            map.put("status", 0);
        }

        return map;
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

}

