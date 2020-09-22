package com.zlk.group4.ordinary.service.impl;

import com.zlk.group4.ordinary.mapper.HouseRefDeployMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.ordinary.entity.HouseRefDeploy;
import com.zlk.group4.ordinary.service.HouseRefDeployService;

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

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return houseRefDeployMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HouseRefDeploy record) {
        return houseRefDeployMapper.insert(record);
    }

    @Override
    public int insertSelective(HouseRefDeploy record) {
        return houseRefDeployMapper.insertSelective(record);
    }

    @Override
    public HouseRefDeploy selectByPrimaryKey(Integer id) {
        return houseRefDeployMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HouseRefDeploy record) {
        return houseRefDeployMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HouseRefDeploy record) {
        return houseRefDeployMapper.updateByPrimaryKey(record);
    }

}

