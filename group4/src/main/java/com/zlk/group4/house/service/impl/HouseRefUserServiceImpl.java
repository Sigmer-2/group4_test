package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseRefUserMapper;
import com.zlk.group4.house.service.*;
import com.zlk.group4.vo.HouseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.HouseRefUser;

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

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return houseRefUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HouseRefUser record) {
        return houseRefUserMapper.insert(record);
    }

    @Override
    public int insertSelective(HouseRefUser record) {
        return houseRefUserMapper.insertSelective(record);
    }

    @Override
    public HouseRefUser selectByPrimaryKey(Integer id) {
        return houseRefUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HouseRefUser record) {
        return houseRefUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HouseRefUser record) {
        return houseRefUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<HouseMsg> listAll() {

        return null;
    }

}


