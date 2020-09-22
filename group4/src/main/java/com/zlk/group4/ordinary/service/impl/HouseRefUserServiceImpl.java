package com.zlk.group4.ordinary.service.impl;

import com.zlk.group4.ordinary.mapper.HouseRefUserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.ordinary.entity.HouseRefUser;
import com.zlk.group4.ordinary.service.HouseRefUserService;

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

}

