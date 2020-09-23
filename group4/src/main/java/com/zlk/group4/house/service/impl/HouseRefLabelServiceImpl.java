package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.entity.HouseLabel;
import com.zlk.group4.house.mapper.HouseLabelMapper;
import com.zlk.group4.house.mapper.HouseRefLabelMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.HouseRefLabel;
import com.zlk.group4.house.service.HouseRefLabelService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

@Service
public class HouseRefLabelServiceImpl implements HouseRefLabelService {

    @Resource
    private HouseRefLabelMapper houseRefLabelMapper;

    @Resource
    private HouseLabelMapper houseLabelMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return houseRefLabelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HouseRefLabel record) {
        return houseRefLabelMapper.insert(record);
    }

    @Override
    public int insertSelective(HouseRefLabel record) {
        return houseRefLabelMapper.insertSelective(record);
    }

    @Override
    public HouseRefLabel selectByPrimaryKey(Integer id) {
        return houseRefLabelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HouseRefLabel record) {
        return houseRefLabelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HouseRefLabel record) {
        return houseRefLabelMapper.updateByPrimaryKey(record);
    }

    @Override
    public HouseRefLabel selectLabelByHouseId(Integer id) {
        return houseRefLabelMapper.selectLabelByHouseId(id);
    }

    @Override
    public String label(Integer id) {
        StringBuffer sb = new StringBuffer();
        HouseRefLabel houseRefLabel = houseRefLabelMapper.selectLabelByHouseId(id);
        HouseLabel houseLabel = houseLabelMapper.selectByPrimaryKey(houseRefLabel.getHouseLabelId());
            if (houseLabel.getShortRent() == 1){
                sb.append("可短租，");
            }if (houseLabel.getPayment() == 1){
                sb.append("月付，");
            }if (houseLabel.getSouthward() == 1){
                sb.append("南向，");
            }if (houseLabel.getAgencyfee() == 1){
                sb.append("无中介费，");
            }if (houseLabel.getToilet() == 1){
                sb.append("独卫，");
            }if (houseLabel.getBalcony() == 1){
                sb.append("独立阳台，");
            }if (houseLabel.getElevator() == 1){
                sb.append("电梯房，");
            }if (houseLabel.getBayWindow() == 1){
                sb.append("带飘窗，");
            }if (houseLabel.getDecoration() == 1){
                sb.append("精装修");
            }

        return sb.toString();
    }

}


