package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseImgMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.service.HouseImgService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

@Service
public class HouseImgServiceImpl implements HouseImgService {

    @Resource
    private HouseImgMapper houseImgMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return houseImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HouseImg record) {
        return houseImgMapper.insert(record);
    }

    @Override
    public int insertSelective(HouseImg record) {
        return houseImgMapper.insertSelective(record);
    }

    @Override
    public HouseImg selectByPrimaryKey(Integer id) {
        return houseImgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HouseImg record) {
        return houseImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HouseImg record) {
        return houseImgMapper.updateByPrimaryKey(record);
    }

}

