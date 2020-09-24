package com.zlk.group4.house.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lihongying
 * Date: 2020-09-23
 * Time: 9:17
 */
@Controller
public class LandController {
    @RequestMapping(value = "/home")
    public String home()throws Exception{//跳转home界面

        return "/ordinary/home";
    }

}
