package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseRefImgMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.HouseRefImg;
import com.zlk.group4.house.service.HouseRefImgService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

@Service
public class HouseRefImgServiceImpl implements HouseRefImgService {

    @Resource
    private HouseRefImgMapper houseRefImgMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return houseRefImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HouseRefImg record) {
        return houseRefImgMapper.insert(record);
    }

    @Override
    public int insertSelective(HouseRefImg record) {
        return houseRefImgMapper.insertSelective(record);
    }

    @Override
    public HouseRefImg selectByPrimaryKey(Integer id) {
        return houseRefImgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HouseRefImg record) {
        return houseRefImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HouseRefImg record) {
        return houseRefImgMapper.updateByPrimaryKey(record);
    }

}

