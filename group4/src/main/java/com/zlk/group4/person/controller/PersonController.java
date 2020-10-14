package com.zlk.group4.person.controller;

import com.alibaba.fastjson.JSON;
import com.zlk.group4.area.entity.Area;
import com.zlk.group4.area.entity.Street;
import com.zlk.group4.entity.User;
import com.zlk.group4.fdfs.CommonFileUtil;
import com.zlk.group4.fdfs.FdfsConfig;
import com.zlk.group4.house.entity.*;
import com.zlk.group4.person.service.PersonService;
import com.zlk.group4.person.util.HttpClientUtil;
import com.zlk.group4.person.util.StaticDataUtil;

//import net.sf.json.JSONArray;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//import com.alibaba.fastjson.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;
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

    @Autowired
    //对文件进行上传的工具类
    private CommonFileUtil commonFileUtil;
    @Autowired
    private FdfsConfig fdfsConfig;
    @RequestMapping(value = "/uploadTest")
    @ResponseBody
    public String uploadTest(@RequestParam(name = "file") MultipartFile file) throws Exception{
        //path是文件上传到FastDFS服务器上的路径
        String path = commonFileUtil.uploadFile(file);
        /*
         * url是最终访问文件资源的地址
         * fdfsConfig.getResHost()获取的是服务器的ip
         * fdfsConfig.getStoragePort()获取的是服务器的端口
         */
        String url = fdfsConfig.getResHost()+":"+fdfsConfig.getStoragePort()+path;
        System.out.println(path);
        System.out.println(url);
        return url;
    }


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
        System.out.println(jsonObject2.get("0"));
        String url0 =String.valueOf(jsonObject2.get("0"));
        String url1 = String.valueOf(jsonObject2.get("1"));
        String url2 = String.valueOf(jsonObject2.get("2"));
        imgParams houseImg = new imgParams();
        List<String> url = new ArrayList<String>();
        if(url0!=null&&!url0.equals("null")) {
            url.add(url0);
        }
        if(url1!=null&&!url1.equals("null")) {
            url.add(url1);
        }
        if(url2!=null&&!url2.equals("null")) {
            url.add(url2);
        }
        houseImg.setImgUrl(url);
        //houseImg.setImgUrl();
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

        Integer houseId = house.getId();


        Integer labelId = houseLabel.getId();

        Integer deployId = houseDeploy.getId();
     //  Integer flag2 = personService.insertAll2(houseId,imgId,labelId,deployId);
//        HouseRefImg houseRefImg = new HouseRefImg();
//        houseRefImg.setHouseId(houseId);
//        houseRefImg.setHouseImgId(houseImgId);
        HouseRefLabel houseRefLabel = new HouseRefLabel();
        houseRefLabel.setHouseId(houseId);
        houseRefLabel.setHouseLabelId(labelId);
        HouseRefDeploy houseRefDeploy = new HouseRefDeploy();
        houseRefDeploy.setHouseId(houseId);
        houseRefDeploy.setHouseDeployId(deployId);

//     Integer flag2 =  personService.insertHouseRefImg(houseRefImg);
     Integer flag3 = personService.insertHouseRefLabel(houseRefLabel);
     Integer flag4 =  personService.insertHouseRefDeploy(houseRefDeploy);


        System.out.println(houseId);
       // System.out.println(houseImgId);
        System.out.println(labelId);
        System.out.println(deployId);
        //System.out.println(imgId);
        ///
        if(flag==1&&flag3==1&&flag4==1){
            return 1;
        }else{
            return 0;
        }


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

    /**
     * 登录接口
     *
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/wxLogin", method = RequestMethod.POST)
    public Map<String, Object> wxLogin(String code) throws Exception {
//        JSONObject jsonObject1 = param.getJSONObject("personInfo");
//        JSONObject fromObject1 = JSONObject.fromObject(jsonObject1);
//        User user0 = (User) JSONObject.toBean(fromObject1,User.class);
       // System.out.println(user0);
        //处理URL
        String url = String.format(StaticDataUtil.CODE_URL, StaticDataUtil.APPID, StaticDataUtil.SECRET, code);
        Map<String, Object> map = new HashMap<>();
        Integer flag=null;
        try {
            Map<String, Object> response = HttpClientUtil.sendGet(url);
            //JSONObject json = JSONObject.fromObject(response).getJSONArray.get("entity");
            JSONObject json = JSONObject.fromObject(response.get("entity"));//
            String openId = json.getString("openid");
            String sessionKey = json.getString("session_key");
            System.out.println(openId);
            System.out.println(sessionKey);


            if(openId!=null){
                User user = personService.findUserByOpenId(openId);
                if(user!=null){
                    if(!sessionKey.equals(user.getSessionKey())){
                        flag = personService.updateSessionKey(user.getId(), sessionKey);
                    }else{
                        flag=1;
                    }
                    map.put("openId", openId);
                    map.put("sessionKey", sessionKey);
                    map.put("userId", user.getId());
                    //logger.debug("登录statusCode="+flag);
                    map.put("statusCode", flag);
                    return map;
                }else{
                    //String userId = UUID.randomUUID().toString().substring(0, 13);//自动生成主键
                    User userInsert = new User(sessionKey, openId);

                    flag = personService.insertUserInformation(userInsert);
                    Integer userId = userInsert.getId();//获取userID
                    System.out.println(userId);//打印userId
                    if(flag==1){
                        map.put("openId", openId);
                        map.put("sessionKey", sessionKey);
                        map.put("userId", userId);
                        map.put("statusCode", flag);
                        //logger.debug("登录statusCode="+flag);
                        return map;
                    }else{
                        map.put("statusCode", flag);
                        //logger.debug("登录statusCode="+flag);
                        return map;
                    }
                }
            }else{
                map.put("statusCode", 0);
                //logger.debug("登录statusCode=0");
                return map;
            }


        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", 0);
            //logger.debug("登录statusCode=0");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value="/updateUserById",method = RequestMethod.PUT)
    public Integer update(@RequestBody User user){
        try {
            Integer flag = personService.updateUserById(user);
            //logger.debug("updateUserMessage flag="+flag);
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            //logger.debug("updateUserMessage flag=-1");
            return -1;
        }
    }
}
