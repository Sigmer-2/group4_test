package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.entity.HouseImg;
import com.zlk.group4.house.mapper.HouseImgMapper;
import com.zlk.group4.house.mapper.HouseRefImgMapper;
import com.zlk.group4.house.service.HouseImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.HouseRefImg;
import com.zlk.group4.house.service.HouseRefImgService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Autowired
    private HouseImgService imgService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return houseRefImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(HouseRefImg record) {
        return houseRefImgMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(HouseRefImg record) {
        return houseRefImgMapper.insertSelective(record);
    }

    @Override
    public HouseRefImg selectByPrimaryKey(Integer id) {
        return houseRefImgMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(HouseRefImg record) {
        return houseRefImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(HouseRefImg record) {
        return houseRefImgMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<HouseRefImg> selectImgByHouseId(Integer id) {
        return houseRefImgMapper.selectImgByHouseId(id);
    }



}


