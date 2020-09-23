package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseLabelMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.house.entity.HouseLabel;
import com.zlk.group4.house.service.HouseLabelService;

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
    public int deleteByPrimaryKey(Integer id) {
        return houseLabelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HouseLabel record) {
        return houseLabelMapper.insert(record);
    }

    @Override
    public int insertSelective(HouseLabel record) {
        return houseLabelMapper.insertSelective(record);
    }

    @Override
    public HouseLabel selectByPrimaryKey(Integer id) {
        return houseLabelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HouseLabel record) {
        return houseLabelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HouseLabel record) {
        return houseLabelMapper.updateByPrimaryKey(record);
    }

}


