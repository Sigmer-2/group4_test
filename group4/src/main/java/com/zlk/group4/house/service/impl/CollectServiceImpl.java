package com.zlk.group4.house.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.house.entity.Collect;
import com.zlk.group4.house.mapper.CollectMapper;
import com.zlk.group4.house.service.CollectService;
/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: sunshuai
 * Date: 2020-10-12
 * Time: 13:38
 */
    
@Service
public class CollectServiceImpl implements CollectService{

    @Resource
    private CollectMapper collectMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return collectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Collect record) {
        return collectMapper.insert(record);
    }

    @Override
    public int insertSelective(Collect record) {
        return collectMapper.insertSelective(record);
    }

    @Override
    public Collect selectByPrimaryKey(Integer id) {
        return collectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Collect record) {
        return collectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Collect record) {
        return collectMapper.updateByPrimaryKey(record);
    }

}