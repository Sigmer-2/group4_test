package com.zlk.group4.house.controller;

import com.zlk.group4.house.entity.*;
import com.zlk.group4.house.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有关房屋信息的操作
 * @author: zhc
 * @time: 2020/9/23 17:45
 */
@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseRefLabelService houseRefLabelService;
    @Autowired
    private HouseRefDeployService houseRefDeployService;
    @Autowired
    private HouseRefImgService houseRefImgService;
    @Autowired
    private HouseRefUserService houseRefUserService;


    @RequestMapping(value = "/adminFindAllHouse")
    @ResponseBody
    public Map<String, Object> findHouseAll(Integer page, Integer limit) throws Exception{
        Map<String,Object> paraMap = new HashMap<String,Object>();
        List<House> houseList = houseService.adminManageHouse(paraMap,page,limit);
        for (House house : houseList) {
           Integer i = house.getHouseRefLabel().getId();
           house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
           house.getHouseRefLabel().setId(i);
           Integer j = house.getHouseRefDeploy().getId();
           house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
           house.getHouseRefDeploy().setId(j);
           house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
           house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
        }
        Integer count = houseService.findHouseCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg","");
        map.put("data", houseList);
        map.put("count", count);
        return map;
    }
    @RequestMapping(value = "/findImgsByHouseId")
    @ResponseBody
    public Map<String,Object> findImgsByHouseId(Integer id) throws Exception{
        List<HouseRefImg> houseRefImgs = houseRefImgService.selectImgByHouseId(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg","");
        map.put("data", houseRefImgs);
        return map;
    }

    @RequestMapping(value = "/AdminfindHouseBy")
    @ResponseBody
    public Map<String,Object> AdminfindHouseBy(Integer select,String data) throws Exception{
        if(select==null) {
            select = 0;
        }
        System.out.println(select+" "+data);
        if(select==0){
            List<House> houseList = houseService.findHouseByRegion(data);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg","");
            map.put("data",houseList);
            return map;
        }
        else if(select==1) {
            List<House> houseList = houseService.findHouseByMetro(data);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg","");
            map.put("data",houseList);
            return map;
        }else if(select==2){
            BigDecimal bd=new BigDecimal(data);
            List<House> houseList = houseService.findHouseByRent(bd);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg","");
            map.put("data",houseList);
            return map;
        }
        else if(select==3){
            List<House> houseList = houseService.findHouseByHouseType(data);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg","");
            map.put("data",houseList);
            return map;
        }
        else {
            List<House> houseList = houseService.findHouseByRentalModel(data);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg","");
            map.put("data",houseList);
            return map;
        }
    }

}
