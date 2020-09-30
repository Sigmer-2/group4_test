package com.zlk.group4.house.controller;

import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseRefImg;
import com.zlk.group4.house.service.HouseImgService;
import com.zlk.group4.house.service.HouseRefImgService;
import com.zlk.group4.house.service.HouseRefUserService;
import com.zlk.group4.util.ImgUtil;
import com.zlk.group4.vo.HouseMsg;
import com.zlk.group4.vo.ServerLayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-24
 * Time: 14:01
 */
@RestController
@RequestMapping("/house")
public class RestHouseController {


    @Autowired
    private HouseRefUserService houseRefUserService;

    @Autowired
    private HouseImgService imgService;

    @Autowired
    private HouseRefImgService houseRefImgService;

    private HouseMsg houseMsg = null;

    private ServerLayResponse serverLayResponse = null;


    @GetMapping("/list")
    @ResponseBody
    public ServerLayResponse getList(){
//    System.out.println("进入");
        serverLayResponse = new ServerLayResponse();
        Integer useId = 1;
        List<HouseMsg> list = houseRefUserService.listAllByUserId(useId);
        serverLayResponse.setCode(0);
        serverLayResponse.setMsg("");
        serverLayResponse.setCount(list.size());
        serverLayResponse.setData(list);
        return serverLayResponse;
    }


    @PostMapping("/add")
    @ResponseBody
    public Map<String,Object> add(HouseMsg houseMsg){
        Map<String,Object> map = new HashMap<>();
        int i = houseRefUserService.insertHouseMsg(houseMsg);
        if (i == 0){
            map.put("status",500);
        }else {
            map.put("status",1);
        }
        return map;
    }


    @PostMapping("/edit")
    @ResponseBody
    public Map<String,Object> edit(HouseMsg houseMsg){
        Map<String,Object> map = new HashMap<>();
        int i = houseRefUserService.updateByHouseMsg(houseMsg);
        if (0<i&&i<=5){
            map.put("status",1);
        } else {
            map.put("status", 500);
        }
        return map;
    }


    @PostMapping("/delete")
    @ResponseBody
    public Map<String,Object> delete(@RequestParam("ids") List<Integer> ids){
        Map<String,Object> map = new HashMap<>();
        if (ids.size()==0){
            map.put("status",500);
        }
        for (Integer id : ids) {
            //
            int i = houseRefUserService.deleteHouseMsg(id);
            if (i==7){
                map.put("status",1);
            }else {
                map.put("status",500);
            }
        }
        return map;
    }


    @PostMapping("/upload")
    @ResponseBody
    public Map<String,Object> addImg(MultipartFile file, HttpServletRequest request) throws IllegalStateException, IOException {
        Map<String, Object> map = new HashMap<>();
        String addImgs = ImgUtil.addImg(file, request);
        int houseId = Integer.parseInt(request.getParameter("houseId"));
        if (addImgs!=null){
            HouseImg houseImg = new HouseImg();
            HouseRefImg houseRefImg = new HouseRefImg();
            houseImg.setImgUrl(addImgs);
            houseImg.setImgPage(0);
            imgService.insert(houseImg);
            houseRefImg.setHouseId(houseId);
            houseRefImg.setHouseImgId(houseImg.getId());
            houseRefImgService.insert(houseRefImg);
            map.put("code",0);
        }else {
            map.put("code",500);
        }
        return map;
    }


}
