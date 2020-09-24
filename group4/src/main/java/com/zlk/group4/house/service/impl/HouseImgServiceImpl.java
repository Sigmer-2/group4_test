package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.HouseImgMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.service.HouseImgService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return houseImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(HouseImg record) {
        return houseImgMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(HouseImg record) {
        return houseImgMapper.insertSelective(record);
    }

    @Override
    public HouseImg selectByPrimaryKey(Integer id) {
        return houseImgMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(HouseImg record) {
        return houseImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(HouseImg record) {
        return houseImgMapper.updateByPrimaryKey(record);
    }

}


