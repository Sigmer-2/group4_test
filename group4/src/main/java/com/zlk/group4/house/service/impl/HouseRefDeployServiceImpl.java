package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.entity.HouseDeploy;
import com.zlk.group4.house.mapper.HouseDeployMapper;
import com.zlk.group4.house.mapper.HouseRefDeployMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.house.entity.HouseRefDeploy;
import com.zlk.group4.house.service.HouseRefDeployService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

@Service
public class HouseRefDeployServiceImpl implements HouseRefDeployService {

    @Resource
    private HouseRefDeployMapper houseRefDeployMapper;

    @Resource
    private HouseDeployMapper deployMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return houseRefDeployMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(HouseRefDeploy record) {
        return houseRefDeployMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(HouseRefDeploy record) {
        return houseRefDeployMapper.insertSelective(record);
    }

    @Override
    public HouseRefDeploy selectByPrimaryKey(Integer id) {
        return houseRefDeployMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(HouseRefDeploy record) {
        return houseRefDeployMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(HouseRefDeploy record) {
        return houseRefDeployMapper.updateByPrimaryKey(record);
    }

    @Override
    public HouseRefDeploy selectDeployByHouseId(Integer id) {
        return houseRefDeployMapper.selectDeployByHouseId(id);
    }

    @Override
    public String houseDeploy(Integer id) {
        StringBuffer sb = new StringBuffer();
        HouseRefDeploy houseRefDeploy = houseRefDeployMapper.selectDeployByHouseId(id);
        HouseDeploy houseDeploy = deployMapper.selectByPrimaryKey(houseRefDeploy.getHouseDeployId());
        if (houseDeploy.getBed() == 1){
            sb.append("床,");
        }if (houseDeploy.getWifi() == 1){
            sb.append("WIFI,");
        }if (houseDeploy.getConditioner() == 1){
            sb.append("空调,");
        }if (houseDeploy.getWardrobe() == 1){
            sb.append("衣柜,");
        }if (houseDeploy.getDesk() == 1){
            sb.append("书桌,");
        }if (houseDeploy.getChair() == 1){
            sb.append("椅子,");
        }if (houseDeploy.getSofa() == 1){
            sb.append("沙发,");
        }if (houseDeploy.getRefrigerator() == 1){
            sb.append("冰箱,");
        }if (houseDeploy.getWashing() == 1){
            sb.append("洗衣机,");
        }if (houseDeploy.getTv() == 1){
            sb.append("电视机,");
        }if (houseDeploy.getHeater() == 1){
            sb.append("热水器,");
        }if (houseDeploy.getStove() == 1){
            sb.append("燃气灶,");
        }if (houseDeploy.getMicrowave() == 1){
            sb.append("微波炉,");
        }if (houseDeploy.getLampblack() == 1){
            sb.append("油烟机,");
        }if (houseDeploy.getDining() == 1){
            sb.append("餐桌椅,");
        }if (houseDeploy.getLock() == 1){
            sb.append("智能锁,");
        }if (houseDeploy.getLed() == 1){
            sb.append("台灯,");
        }
        return sb.toString();
    }

}


