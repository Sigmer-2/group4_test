package com.zlk.group4.person.service.impl;

import com.zlk.group4.area.entity.Area;
import com.zlk.group4.area.entity.Street;
import com.zlk.group4.entity.User;
import com.zlk.group4.house.entity.*;
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
    public Integer insertAll(House house,imgParams imgParams,HouseLabel houseLabel,HouseDeploy houseDeploy){
        Integer flag1=personMapper.saveHouse(house);
        Integer flag2 = 0;
        Integer a =0;
        Integer b =0;
        Integer houseid = house.getId();
        List<String> imgurl= imgParams.getImgUrl();
        for (int i = 0; i <imgurl.size(); i++) {
            String ll = imgurl.get(i);
            HouseImg houseImg= new HouseImg();
            houseImg.setImgUrl(ll);
            Integer j =personMapper.saveHouseImg(houseImg);
            HouseRefImg houseRefImg =new HouseRefImg();
            houseRefImg.setHouseImgId(houseImg.getId());
            houseRefImg.setHouseId(houseid);
            Integer h = personMapper.insertHouseRefImg(houseRefImg);
            a+=j;
            b+=h;
            if(a==(i+1)&&b==(i+1)&&(i+1)==imgParams.getImgUrl().size())
            {
                flag2=1;
            }
        }
        Integer flag3=personMapper.saveHouseLabel(houseLabel);
        Integer flag4=personMapper.saveHouseDeploy(houseDeploy);
       // Integer id1=personMapper.getId();
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

    @Override
    public Integer updateUserById(User user) {
        return personMapper.updateUserById(user);
    }

    @Override
    public Integer saveHouseImg(HouseImg houseImg) {
        return personMapper.saveHouseImg(houseImg);
    }

    @Override
    public Integer insertHouseRefImg(HouseRefImg houseRefImg) {
        return personMapper.insertHouseRefImg(houseRefImg);
    }

    @Override
    public Integer insertHouseRefLabel(HouseRefLabel houseRefLabel) {
        return personMapper.insertHouseRefLabel(houseRefLabel);
    }

    @Override
    public Integer insertHouseRefDeploy(HouseRefDeploy houseRefDeploy) {
        return personMapper.insertHouseRefDeploy(houseRefDeploy);
    }


}
