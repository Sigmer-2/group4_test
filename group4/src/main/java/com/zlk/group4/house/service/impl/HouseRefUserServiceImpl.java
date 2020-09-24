package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.entity.HouseRefDeploy;
import com.zlk.group4.house.entity.HouseRefLabel;
import com.zlk.group4.house.enums.HouseSexEnum;
import com.zlk.group4.house.mapper.HouseRefUserMapper;
import com.zlk.group4.house.service.*;
import com.zlk.group4.vo.HouseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.HouseRefUser;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

@Service
public class HouseRefUserServiceImpl implements HouseRefUserService {

    @Resource
    private HouseRefUserMapper houseRefUserMapper;

    @Autowired
    private HouseService houseService;

    @Autowired
    private HouseRefDeployService houseRefDeployService;

    @Autowired
    private HouseRefLabelService houseRefLabelService;

    @Autowired
    private HouseRefImgService houseRefImgService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private MetroService metroService;

    @Autowired
    private HouseDeployService deployService;

    @Autowired
    private HouseLabelService labelService;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return houseRefUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(HouseRefUser record) {
        return houseRefUserMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(HouseRefUser record) {
        return houseRefUserMapper.insertSelective(record);
    }

    @Override
    public HouseRefUser selectByPrimaryKey(Integer id) {
        return houseRefUserMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(HouseRefUser record) {
        return houseRefUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(HouseRefUser record) {
        return houseRefUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<HouseMsg> listAllByUserId(Integer id) {
        List<HouseMsg> list = new ArrayList<>();
        HouseMsg houseMsg = null;
        List<HouseRefUser> houseRefUsers = houseRefUserMapper.selectHouseByUserId(id);
        for (HouseRefUser houseRefUser : houseRefUsers) {
          //
            House house = houseService.selectAllById(houseRefUser.getHouseId());
            Integer code = house.getSex();
            HouseSexEnum houseSex = HouseSexEnum.getHouseSex(code);
            houseMsg = new HouseMsg();
            houseMsg.setId(houseRefUser.getHouseId());
            houseMsg.setHouseType(house.getHouseType());
            houseMsg.setArea(house.getRegion().getDistrctName()+"，"+house.getRegion().getStreet());
            houseMsg.setMetro(house.getMetro().getMetroLine()+"，"+house.getMetro().getStation());
            houseMsg.setListingsType(house.getListingsType());
            houseMsg.setRentalMode(house.getRentalMode());
            houseMsg.setRoomType(house.getRoomType());
            houseMsg.setRent(house.getRent());
            houseMsg.setHouseLabel(houseRefLabelService.label(houseRefUser.getHouseId()));
            houseMsg.setHouseDeploy(houseRefDeployService.houseDeploy(houseRefUser.getHouseId()));
            houseMsg.setHouseIntroduction(house.getHouseIntroduction());
            houseMsg.setCheckinTime(house.getCheckinTime());
            houseMsg.setSex(houseSex.getDesc());
            houseMsg.setCall(house.getCall());
            houseMsg.setTel(house.getTel());
            list.add(houseMsg);
        }

        return list;
    }

    @Override
    public List<HouseRefUser> selectHouseByUserId(Integer id) {
        return houseRefUserMapper.selectHouseByUserId(id);
    }

    @Override
    public int deleteHouseMsg(Integer id) {
        House house = houseService.selectByPrimaryKey(id);
        HouseRefDeploy houseRefDeploy = houseRefDeployService.selectDeployByHouseId(id);
        HouseRefLabel houseRefLabel = houseRefLabelService.selectLabelByHouseId(id);
        int i = houseService.deleteByPrimaryKey(id);
        int i1 = regionService.deleteByPrimaryKey(house.getRegionId());
        int i2 = metroService.deleteByPrimaryKey(house.getMetroId());
        int i3 = houseRefDeployService.deleteByPrimaryKey(houseRefDeploy.getId());
        int i4 = deployService.deleteByPrimaryKey(houseRefDeploy.getHouseDeployId());
        int i5 = houseRefLabelService.deleteByPrimaryKey(houseRefLabel.getId());
        int i6 = labelService.deleteByPrimaryKey(houseRefLabel.getHouseLabelId());
        return i+i1+i2+i3+i4+i5+i6;
    }

    @Override
    public int updateByHouseMsg(HouseMsg houseMsg) {

        return 0;
    }

    /**
     * 根据houseMsg获取所需对象集合
     * @Auther sunshuai
     * @Date 2020/9/24 9:11
     * @param houseMsg
     * @return java.util.List<java.lang.Object>
     */
    private List<Object> getObjectList(HouseMsg houseMsg){
        List<Object> list = new ArrayList<>();
        House house = houseService.selectByPrimaryKey(houseMsg.getId());
        house.setId(houseMsg.getId());
        house.setListingsType(houseMsg.getListingsType());
        house.setRentalMode(houseMsg.getRentalMode());
        house.setRoomType(houseMsg.getRoomType());
        house.setRent(houseMsg.getRent());
        house.setHouseIntroduction(houseMsg.getHouseIntroduction());
        house.setCheckinTime(houseMsg.getCheckinTime());
        house.setSex(HouseSexEnum.getHouseSex(houseMsg.getSex()).getCode());
        house.setCall(houseMsg.getCall());
        house.setTel(houseMsg.getTel());
        house.setCode(1);
        house.setCreateTime(new Date());
        house.setUpdateTime(new Date());
        list.add(house);
        String houseLabel = houseMsg.getHouseLabel();
        list.add(houseLabel);
        String houseDeploy = houseMsg.getHouseDeploy();
        list.add(houseDeploy);
        return list;
    }

}


