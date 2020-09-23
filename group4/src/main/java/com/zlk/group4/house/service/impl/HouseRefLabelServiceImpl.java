package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseRefLabelMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.HouseRefLabel;
import com.zlk.group4.house.service.HouseRefLabelService;

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

}

