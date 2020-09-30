package com.zlk.group4.person.controller;

import com.zlk.group4.area.entity.Area;
import com.zlk.group4.area.entity.Street;
import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.entity.HouseDeploy;
import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseLabel;
import com.zlk.group4.person.service.PersonService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * @author:sunjiahe
 * @date:2020/9/27
 * @descreption:
 */
@Controller
public class PersonController {
    @Autowired(required = false)
    private PersonService personService;


    @ResponseBody
    @RequestMapping(value = "/findUserName",method = RequestMethod.GET)
    public String fingusername(Integer id){
        try {
            String name=personService.findUserName(id);
            return name;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findUserImg",method = RequestMethod.GET)
    public String finguserimg(Integer id){
        try {
            String img=personService.findUserImg(id);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/insertAll",method = RequestMethod.POST)
    public Integer insertAll(@RequestBody JSONObject param){
        JSONObject jsonObject1 = param.getJSONObject("house");
        JSONObject fromObject1 = JSONObject.fromObject(jsonObject1);
        House house = (House) JSONObject.toBean(fromObject1,House.class);
        System.out.println(house);
        JSONObject jsonObject2 = param.getJSONObject("houseImg");
        JSONObject fromObject2 = JSONObject.fromObject(jsonObject2);
        HouseImg houseImg = (HouseImg) JSONObject.toBean(fromObject2,HouseImg.class);
        System.out.println(houseImg);
        JSONObject jsonObject3 = param.getJSONObject("houseLabel");
        JSONObject fromObject3 = JSONObject.fromObject(jsonObject3);
        HouseLabel houseLabel = (HouseLabel) JSONObject.toBean(fromObject3,HouseLabel.class);
        System.out.println(houseLabel);
        JSONObject jsonObject4 = param.getJSONObject("houseDeploy");
        JSONObject fromObject4 = JSONObject.fromObject(jsonObject4);
        HouseDeploy houseDeploy = (HouseDeploy) JSONObject.toBean(fromObject4,HouseDeploy.class);
        System.out.println(houseDeploy);
        Integer flag = personService.insertAll(house,houseImg,houseLabel,houseDeploy);
        return flag;

    }

    @ResponseBody
    @RequestMapping(value = "/findChangChunAreaAll",method = RequestMethod.GET)
    public Map<String,Object> findChangChunAreaAll(Integer page,Integer limit){
        List<Area> areaList = personService.findChangChunAreaAll(page, limit);
        Integer count = personService.findChangChunAreaCount();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",areaList);
        map.put("page",count);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/findStreetByAreaId",method = RequestMethod.GET)
    public  Map<String,Object> findStreetByAreaId(Integer page,Integer limit,Integer id){
        List<Street> streetList = personService.findStreetByAreaId(page, limit, id);
        Integer count = personService.findChangChunStreetCount(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("data",streetList);
        map.put("page",count);
        return map;
    }

}
