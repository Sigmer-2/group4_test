package com.zlk.group4.house.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlk.group4.entity.User;
import com.zlk.group4.fdfs.CommonFileUtil;
import com.zlk.group4.fdfs.FdfsConfig;
import com.zlk.group4.house.entity.Collect;
import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseRefImg;
import com.zlk.group4.house.service.*;
import com.zlk.group4.service.UserService;
import com.zlk.group4.util.MyHouseUtils;
import com.zlk.group4.vo.HouseMsg;
import com.zlk.group4.vo.ServerLayResponse;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:跟房屋有关的请求
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

    @Autowired
    private CollectService collectService;

    @Autowired
    private UserService userService;

    @Autowired
    //对文件进行上传的工具类
    private CommonFileUtil commonFileUtil;

    @Autowired
    private FdfsConfig fdfsConfig;

    private ServerLayResponse serverLayResponse = null;


    @GetMapping("/list")
    @ResponseBody
    public ServerLayResponse getList(){
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.selectUserByName1(principal);
        serverLayResponse = new ServerLayResponse();
        List<HouseMsg> list = houseRefUserService.listAllByUserId(user.getId());
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
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.selectUserByName1(principal);
        int i = houseRefUserService.insertHouseMsg(houseMsg,user.getId());
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
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        User user = userService.selectUserByName1(principal);
        if (ids.size()==0){
            map.put("status",500);
        }
        for (Integer id : ids) {
          //
            int i = houseRefUserService.deleteHouseMsg(user.getId(),id);
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

        //path是文件上传到FastDFS服务器上的路径
        String path = commonFileUtil.uploadFile(file);
        /*
         * url是最终访问文件资源的地址
         * fdfsConfig.getResHost()获取的是服务器的ip
         * fdfsConfig.getStoragePort()获取的是服务器的端口
         */
        String url = fdfsConfig.getResHost()+":"+fdfsConfig.getStoragePort()+path;
        int houseId = Integer.parseInt(request.getParameter("houseId"));
        if (path!=null){
            HouseImg houseImg = new HouseImg();
            HouseRefImg houseRefImg = new HouseRefImg();
            houseImg.setImgUrl(url);
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
    @ResponseBody
    public Map<String,Object> getMap(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        JSONObject result = MyHouseUtils.getResult(request);
        String id = result.getString("houseId");
        String userId = result.getString("userId");
        System.out.println(userId+""+id+"=============================");
        if ("".equals(userId)||"".equals(id)){
            map.put("msg","请登录");
        }else{
        Map<String, Object> houseInfo = houseService.findHouseInfoById(Integer.parseInt(id));
//        House house = (House)houseInfo.get("house");
        Map<String, Object> map1 = houseRefUserService.listAllByHouseId(Integer.parseInt(id));
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
        Collect collect = collectService.findAllByCollectUseridAndCollectHouseid(Integer.parseInt(userId), Integer.parseInt(id));
            if (collect!=null){
                map.put("collect","已收藏");
            }else {
                map.put("collect","收藏");
            }
        }
        return map;
    }

    @PostMapping(value = "/collect",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> collect(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        JSONObject result = MyHouseUtils.getResult(request);
        String userId = result.getString("userId");
        String houseId = result.getString("houseId");
        if ("".equals(userId)&&"".equals(houseId)){
            map.put("msg","请登录");
        }else {
            Collect collect = new Collect();
            collect.setCollectUserid(Integer.parseInt(userId));
            collect.setCollectHouseid(Integer.parseInt(houseId));
            collect.setCollectTime(new Date());
            int insert = collectService.insertSelective(collect);
            if (insert>0){
                map.put("code",0);
            }else {
                map.put("code",500);
            }
        }
        return map;
    }


    @PostMapping(value = "/deleteCollect",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String,Object> deleteCollect(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        JSONObject result = MyHouseUtils.getResult(request);
        String userId = result.getString("userId");
        String houseId = result.getString("houseId");
        if ("".equals(userId)&&"".equals(houseId)){
            map.put("msg","请登录");
        }else {
            int i= collectService.deleteByCollectUseridAndCollectHouseid(Integer.parseInt(userId), Integer.parseInt(houseId));
            if (i>0){
                map.put("code",0);
            }else {
                map.put("code",500);
            }
        }

        return map;
    }
}
