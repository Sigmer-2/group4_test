package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseDeployMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.HouseDeploy;
import com.zlk.group4.house.service.HouseDeployService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

@Service
public class HouseDeployServiceImpl implements HouseDeployService {

    @Resource
    private HouseDeployMapper houseDeployMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return houseDeployMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(HouseDeploy record) {
        return houseDeployMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(HouseDeploy record) {
        return houseDeployMapper.insertSelective(record);
    }

    @Override
    public HouseDeploy selectByPrimaryKey(Integer id) {
        return houseDeployMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(HouseDeploy record) {
        return houseDeployMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(HouseDeploy record) {
        return houseDeployMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByStr(String str) {
        HouseDeploy houseDeploy = getHouseDeploy(str);
        return updateByPrimaryKey(houseDeploy);
    }

    /**
     * 根据配置字符串通过截取字符串将对应的值存入到HouseDeploy对象
     * 中去
     * @Auther sunshuai
     * @Date 2020/9/23 21:34
     * @param str 配置栏获取的字符串
     * @return com.zlk.group4.house.entity.HouseDeploy
     */
    private HouseDeploy getHouseDeploy(String str){
        HouseDeploy houseDeploy = null;
        String[] strs = str.split("，");
        houseDeploy = new HouseDeploy();
        for (String s : strs) {
            switch (s){
                case "床" : houseDeploy.setBed(1);break;
                case "WIFI" : houseDeploy.setWifi(1);break;
                case "衣柜" : houseDeploy.setWardrobe(1);break;
                case "书桌" : houseDeploy.setDesk(1);break;
                case "椅子" : houseDeploy.setChair(1);break;
                case "沙发" : houseDeploy.setSofa(1);break;
                case "冰箱" : houseDeploy.setRefrigerator(1);break;
                case "洗衣机" : houseDeploy.setWashing(1);break;
                case "电视机" : houseDeploy.setTv(1);break;
                case "热水器" : houseDeploy.setHeater(1);break;
                case "燃气灶" : houseDeploy.setStove(1);break;
                case "微波炉" : houseDeploy.setMicrowave(1);break;
                case "油烟机" : houseDeploy.setLampblack(1);break;
                case "餐桌椅" : houseDeploy.setDining(1);break;
                case "智能锁" : houseDeploy.setLock(1);break;
                case "台灯" : houseDeploy.setLed(1);break;
                default:break;
            }
        }
        if (houseDeploy.getBed()==null){
            houseDeploy.setBed(0);
        }if (houseDeploy.getWifi()==null){
            houseDeploy.setWifi(0);
        }if (houseDeploy.getConditioner()==null){
            houseDeploy.setConditioner(0);
        }if (houseDeploy.getWardrobe()==null){
            houseDeploy.setWardrobe(0);
        }if (houseDeploy.getDesk()==null){
            houseDeploy.setDesk(0);
        }if (houseDeploy.getChair()==null){
            houseDeploy.setChair(0);
        }if (houseDeploy.getSofa()==null){
            houseDeploy.setSofa(0);
        }if (houseDeploy.getRefrigerator()==null){
            houseDeploy.setRefrigerator(0);
        }if (houseDeploy.getWashing()==null){
            houseDeploy.setWashing(0);
        }if (houseDeploy.getTv()==null){
            houseDeploy.setTv(0);
        }if (houseDeploy.getHeater()==null){
            houseDeploy.setHeater(0);
        }if (houseDeploy.getStove()==null){
            houseDeploy.setStove(0);
        }if (houseDeploy.getMicrowave()==null){
            houseDeploy.setMicrowave(0);
        }if (houseDeploy.getLampblack()==null){
            houseDeploy.setLampblack(0);
        }if (houseDeploy.getDining()==null){
            houseDeploy.setDining(0);
        }if (houseDeploy.getLock()==null){
            houseDeploy.setLock(0);
        }if (houseDeploy.getLed()==null){
            houseDeploy.setLed(0);
        }
        return houseDeploy;
    }

}


