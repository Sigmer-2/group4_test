package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.RegionMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.house.entity.Region;
import com.zlk.group4.house.service.RegionService;
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
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return regionMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(Region record) {
        return regionMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(Region record) {
        return regionMapper.insertSelective(record);
    }

    @Override
    public Region selectByPrimaryKey(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(Region record) {
        return regionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(Region record) {
        return regionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByString(String str,Integer id) {
        Region region = getRegion(str);
        region.setId(id);
        return updateByPrimaryKey(region);
    }

    @Override
    public int insertByString(String str) {
        Region region = getRegion(str);
        insert(region);
        return region.getId();
    }

    private Region getRegion(String str){
        Region region = new Region();
        String[] strs = str.split(",");
        region.setDistrctName(strs[0]);
        region.setStreet(strs[1]);
        return region;
    }

    @Override
    public Integer adminUpdateRegion(Region region) {
        return regionMapper.adminUpdateRegion(region);
    }
}


