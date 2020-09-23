package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.MetroMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.Metro;
import com.zlk.group4.house.service.MetroService;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-22
 * Time: 15:43
 */

@Service
public class MetroServiceImpl implements MetroService {

    @Resource
    private MetroMapper metroMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return metroMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Metro record) {
        return metroMapper.insert(record);
    }

    @Override
    public int insertSelective(Metro record) {
        return metroMapper.insertSelective(record);
    }

    @Override
    public Metro selectByPrimaryKey(Integer id) {
        return metroMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Metro record) {
        return metroMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Metro record) {
        return metroMapper.updateByPrimaryKey(record);
    }

}



