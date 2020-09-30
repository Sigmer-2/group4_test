package com.zlk.group4.house.service.impl;

import com.zlk.group4.house.mapper.MetroMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.zlk.group4.house.entity.Metro;
import com.zlk.group4.house.service.MetroService;
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
public class MetroServiceImpl implements MetroService {

    @Resource
    private MetroMapper metroMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return metroMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(Metro record) {
        return metroMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(Metro record) {
        return metroMapper.insertSelective(record);
    }

    @Override
    public Metro selectByPrimaryKey(Integer id) {
        return metroMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(Metro record) {
        return metroMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(Metro record) {
        return metroMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByString(String str) {
        return updateByPrimaryKey(getMetro(str));
    }

    @Override
    public int insertByString(String str) {
        Metro metro = getMetro(str);
        insert(metro);
        return metro.getId();
    }


    private Metro getMetro(String str){
        Metro metro = new Metro();
        String[] strs = str.split(",");
        metro.setMetroLine(strs[0]);
        metro.setStation(strs[1]);
        return metro;
    }

    @Override
    public Integer adminUpdateMetro(Metro metro) {
        return metroMapper.adminUpdateMetro(metro);
    }
}



