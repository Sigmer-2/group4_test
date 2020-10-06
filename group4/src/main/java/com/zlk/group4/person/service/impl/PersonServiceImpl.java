package com.zlk.group4.person.service.impl;

import com.zlk.group4.area.entity.Area;
import com.zlk.group4.area.entity.Street;
import com.zlk.group4.entity.User;
import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.entity.HouseDeploy;
import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.entity.HouseLabel;
import com.zlk.group4.person.mapper.PersonMapper;
import com.zlk.group4.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:sunjiahe
 * @date:2020/9/27
 * @descreption:
 */
@Service
public class PersonServiceImpl implements PersonService{

    @Autowired(required = false)
    private PersonMapper personMapper;

    @Override
    public String findUserName(Integer id) {
        return personMapper.findUserName(id);
    }

    @Override
    public String findUserImg(Integer id) {
        return personMapper.findUserImg(id);
    }

    @Override
    @Transactional
    public Integer insertAll(House house,HouseImg houseImg,HouseLabel houseLabel,HouseDeploy houseDeploy){
        Integer flag1=personMapper.saveHouse(house);
        Integer flag2=personMapper.saveHouseImg(houseImg);
        Integer flag3=personMapper.saveHouseLabel(houseLabel);
        Integer flag4=personMapper.saveHouseDeploy(houseDeploy);
        if(flag1==1&&flag2==1&&flag3==1&&flag4==1){
            return 1;
        }else {
            return 0;
        }


    }

    @Override
    public List<Area> findChangChunAreaAll(Integer page,Integer limit) {
        Map<String,Object> paraMap = new HashMap<String, Object>();
        Integer startIndex = (page-1)*limit;
        paraMap.put("startIndex",startIndex);
        paraMap.put("pageSize",limit);
        return personMapper.findChangChunAreaAll(paraMap);
    }

    @Override
    public Integer findChangChunAreaCount() {
        return personMapper.findChangChunAreaCount();
    }

    @Override
    public List<Street> findStreetByAreaId(Integer page, Integer limit, Integer id) {
        return null;
    }

    @Override
    public Integer findChangChunStreetCount(Integer id) {
        return personMapper.findChangChunStreetCount(id);
    }

    @Override
    public User findUserByOpenId(String openId) {
        return personMapper.findUserByOpenId(openId);
    }

    @Override
    public Integer updateSessionKey(Integer id,String sessionKey) {
        return personMapper.updateSessionKey(id,sessionKey);
    }

    @Override
    public Integer insertUserInformation(User user) {
        return personMapper.insertUserInformation(user);
    }


}
