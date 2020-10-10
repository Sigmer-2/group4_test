package com.zlk.group4.house.controller;

import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseRefImg;
import com.zlk.group4.house.service.HouseImgService;
import com.zlk.group4.house.service.HouseRefImgService;
import com.zlk.group4.house.service.HouseRefUserService;
import com.zlk.group4.house.service.HouseService;
import com.zlk.group4.util.ImgUtil;
import com.zlk.group4.util.MyHouseUtils;
import com.zlk.group4.vo.HouseMsg;
import com.zlk.group4.vo.ServerLayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
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

    @Autowired
    private HouseService houseService;

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
        String url = "http://localhost:8080/img/";
        String addImgs = ImgUtil.addImg(file, request);
        int houseId = Integer.parseInt(request.getParameter("houseId"));
        if (addImgs!=null){
            HouseImg houseImg = new HouseImg();
            HouseRefImg houseRefImg = new HouseRefImg();
            houseImg.setImgUrl(url+addImgs);
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


    @PostMapping(value = "/msg",produces = "application/json;charset=UTF-8")
//    @GetMapping("/msg")
    @ResponseBody
    public Map<String,Object> getMap(Integer id){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> houseInfo = houseService.findHouseInfoById(2);
//        House house = (House)houseInfo.get("house");
        Map<String, Object> map1 = houseRefUserService.listAllByHouseId(2);
        HouseMsg houseMsg = (HouseMsg)map1.get("houseMsg");
        String area = houseMsg.getArea();
        String[] areas = area.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : areas) {
          //
            sb.append(s).append("-");
        }
        String estate = houseMsg.getEstate();//小区
        String address = sb.toString()+estate;//住址
        String houseIntroduction = houseMsg.getHouseIntroduction();//房屋介绍
        String houseType = houseMsg.getHouseType();//户型
        BigDecimal rent = houseMsg.getRent();//房租
        String houseLabel = houseMsg.getHouseLabel();
        Map<String, Object> labels = MyHouseUtils.getLabels(houseLabel);//标签
        String rentalMode = houseMsg.getRentalMode();//出租方式
        String listingsType = houseMsg.getListingsType();
        String checkinTime = houseMsg.getCheckinTime();//入住时间
        String houseDeploy = houseMsg.getHouseDeploy();
        Map<String, Object> deploys = MyHouseUtils.getDeploys(houseDeploy);//家电设施
        String tel = houseMsg.getTel();//电话
        List<HouseRefImg> imgs = (List<HouseRefImg>)houseInfo.get("img");
        List listImg = new ArrayList();//照片
        for (HouseRefImg img : imgs) {
          //
            listImg.add(img.getHouseImg().getImgUrl());
        }
        map.put("estate",estate);
        map.put("address",address);
        map.put("houseIntroduction",houseIntroduction);
        map.put("houseType",houseType);
        map.put("rent",rent);
        map.put("labels",labels);
        map.put("rentalMode",rentalMode);
        map.put("listingsType",listingsType);
        map.put("checkinTime",checkinTime);
        map.put("deploys",deploys);
        map.put("tel",tel);
        map.put("listImg",listImg);
        return map;
    }
}
