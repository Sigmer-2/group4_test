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
    /**举报信息查看页面*/
    @RequestMapping(value = "/report")
    public String report(){
        return "admin/report";
    }
    /**报修信息查看页面*/
    @RequestMapping(value = "/repair")
    public String repair(){
        return "admin/repair";
    }
    /**问题与咨询信息查看页面*/
    @RequestMapping(value = "/question")
    public String question(){
        return "admin/question";
    }

    /**普通用户招租表*/
    @RequestMapping(value = "/home")
    public String home()throws Exception{ return "/ordinary/home"; }
}
