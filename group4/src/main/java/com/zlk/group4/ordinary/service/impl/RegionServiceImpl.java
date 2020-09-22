package com.zlk.group4.ordinary.service.impl;

import com.zlk.group4.ordinary.mapper.RegionMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.ordinary.entity.Region;
import com.zlk.group4.ordinary.service.RegionService;

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
    public int deleteByPrimaryKey(Integer id) {
        return regionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Region record) {
        return regionMapper.insert(record);
    }

    @Override
    public int insertSelective(Region record) {
        return regionMapper.insertSelective(record);
    }

    @Override
    public Region selectByPrimaryKey(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Region record) {
        return regionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Region record) {
        return regionMapper.updateByPrimaryKey(record);
    }

}

