package com.zlk.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于页面跳转
 * @author: zhc
 * @time: 2020/9/22 10:16
 */
@Controller
public class PageController {
    /**登录*/
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    /**注册*/
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }
    /**后台布局*/
    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }
    /**管理员招租管理跳转*/
    @RequestMapping(value = "/houseForAdmin")
    public String houseForAdmin(){
        return "admin/houseForAdmin";
    }

}
