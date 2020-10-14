package com.zlk.group4.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-10-08
 * Time: 14:33
 */
public class MyHouseUtils {
    /**
     * 获取labels
     * @Auther sunshuai
     * @Date 2020/10/8 15:13
     * @param str
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String,Object> getLabels(String str){
        Map<String,Object> map = new HashMap<>();
        String[] strs = str.split(",");
        if (strs.length == 0||"".equals(str)){
            map.put("labels","");
            return map;
        }else {
            for (String s : strs) {
                //
                switch (s){
                    case "可短租": map.put("shortRent","可短租");break;
                    case "月付": map.put("payment","月付");break;
                    case "南向": map.put("southward","南向");break;
                    case "无中介费": map.put("agencyfee","无中介费");break;
                    case "独卫": map.put("toilet","独卫");break;
                    case "独立阳台": map.put("balcony","独立阳台");break;
                    case "电梯房": map.put("elevator","电梯房");break;
                    case "带飘窗": map.put("bayWindow","带飘窗");break;
                    case "精装修": map.put("decoration","精装修");break;
                    default:break;
                }
            }
        }
        return map;
    }

    /**
     * 获取deploys
     * @Auther sunshuai
     * @Date 2020/10/8 15:14
     * @param str
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    public static Map<String,Object> getDeploys(String str){
        Map<String,Object> map = new HashMap<>();
        String[] strs = str.split(",");
        if (strs.length == 0||"".equals(str)){
            map.put("labels","");
            return map;
        }else {
            for (String s : strs) {
                switch (s){
                    case "床" : map.put("bed","床");break;
                    case "WIFI" : map.put("wifi","WIFI");break;
                    case "空调" : map.put("conditioner","空调");break;
                    case "衣柜" : map.put("wardrobe","衣柜");break;
                    case "书桌" : map.put("desk","书桌");break;
                    case "椅子" : map.put("chair","椅子");break;
                    case "沙发" : map.put("sofa","沙发");break;
                    case "冰箱" : map.put("refrigerator","冰箱");break;
                    case "洗衣机" : map.put("washing","洗衣机");break;
                    case "电视机" : map.put("tv","电视机");break;
                    case "热水器" : map.put("heater","热水器");break;
                    case "燃气灶" : map.put("stove","燃气灶");break;
                    case "微波炉" : map.put("microwave","微波炉");break;
                    case "油烟机" : map.put("lampblack","油烟机");break;
                    case "餐桌椅" : map.put("dining","餐桌椅");break;
                    case "智能锁" : map.put("lock","智能锁");break;
                    case "台灯" : map.put("led","台灯");break;
                    default:break;
                }
            }
        }
        return map;
    }

    /**
     * 通过request获取JSONObject
     * @Auther sunshuai
     * @Date 2020/10/14 10:08
     * @param request
     * @return com.alibaba.fastjson.JSONObject
     */
    public static JSONObject getResult(HttpServletRequest request){
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
