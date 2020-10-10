package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseLabelMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.house.entity.HouseLabel;
import com.zlk.group4.house.service.HouseLabelService;
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
public class HouseLabelServiceImpl implements HouseLabelService {

    @Resource
    private HouseLabelMapper houseLabelMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return houseLabelMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(HouseLabel record) {
        return houseLabelMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(HouseLabel record) {
        return houseLabelMapper.insertSelective(record);
    }

    @Override
    public HouseLabel selectByPrimaryKey(Integer id) {
        return houseLabelMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(HouseLabel record) {
        return houseLabelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(HouseLabel record) {
        return houseLabelMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByString(String str) {
        HouseLabel houseLabel = getHouseLabel(str);
        return updateByPrimaryKey(houseLabel);
    }

    @Override
    public int insertHouseLabelByString(String str) {
        HouseLabel houseLabel = getHouseLabel(str);
        insert(houseLabel);
        return houseLabel.getId();
    }


    private HouseLabel getHouseLabel(String str){
        HouseLabel houseLabel = null;
        String[] strs = str.split(",");
        houseLabel = new HouseLabel();
        for (String s : strs) {
          //
            switch (s){
                case "可短租": houseLabel.setShortRent(1);break;
                case "月付": houseLabel.setPayment(1);break;
                case "南向": houseLabel.setSouthward(1);break;
                case "无中介费": houseLabel.setAgencyfee(1);break;
                case "独卫": houseLabel.setToilet(1);break;
                case "独立阳台": houseLabel.setBalcony(1);break;
                case "电梯房": houseLabel.setElevator(1);break;
                case "带飘窗": houseLabel.setBayWindow(1);break;
                case "精装修": houseLabel.setDecoration(1);break;
                default:break;
            }
        }
        if (houseLabel.getShortRent() == null){
            houseLabel.setShortRent(0);
        }if (houseLabel.getPayment() == null){
            houseLabel.setPayment(0);
        }if (houseLabel.getSouthward() == null){
            houseLabel.setSouthward(0);
        }if (houseLabel.getAgencyfee() == null){
            houseLabel.setAgencyfee(0);
        }if (houseLabel.getToilet() == null){
            houseLabel.setToilet(0);
        }if (houseLabel.getBalcony() == null){
            houseLabel.setBalcony(0);
        }if (houseLabel.getElevator() == null){
            houseLabel.setElevator(0);
        }if (houseLabel.getBayWindow() == null){
            houseLabel.setBayWindow(0);
        }if (houseLabel.getDecoration() == null){
            houseLabel.setDecoration(0);
        }
        return houseLabel;
    }

}


