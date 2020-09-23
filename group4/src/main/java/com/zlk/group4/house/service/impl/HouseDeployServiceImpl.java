package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseDeployMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.HouseDeploy;
import com.zlk.group4.house.service.HouseDeployService;

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
    public int deleteByPrimaryKey(Integer id) {
        return houseDeployMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HouseDeploy record) {
        return houseDeployMapper.insert(record);
    }

    @Override
    public int insertSelective(HouseDeploy record) {
        return houseDeployMapper.insertSelective(record);
    }

    @Override
    public HouseDeploy selectByPrimaryKey(Integer id) {
        return houseDeployMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HouseDeploy record) {
        return houseDeployMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HouseDeploy record) {
        return houseDeployMapper.updateByPrimaryKey(record);
    }

}

