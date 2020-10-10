package com.zlk.group4.service.impl;

import com.zlk.group4.entity.Area;
import com.zlk.group4.entity.Line;
import com.zlk.group4.entity.Station;
import com.zlk.group4.entity.Street;
import com.zlk.group4.house.mapper.HouseMapper;
import com.zlk.group4.mapper.ChangchunMapper;
import com.zlk.group4.service.ChangchunService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhc
 * @time: 2020/9/29 12:02
 */
@Service
public class ChangchunServiceImpl implements ChangchunService {
    @Resource
    private ChangchunMapper changchunMapper;

    @Override
    public List<Area> findAllArea() {
        return changchunMapper.findAllArea();
    }

    @Override
    public List<Street> findStreet(Integer id) {
        return changchunMapper.findStreet(id);
    }

    @Override
    public List<Line> findAllLine() {
        return changchunMapper.findAllLine();
    }

    @Override
    public List<Station> findStation(Integer id) {
        return changchunMapper.findStation(id);
    }

    @Override
    public String findAreaName(Integer id) {
        return changchunMapper.findAreaName(id);
    }

    @Override
    public String findStreetName(Integer id) {
        return changchunMapper.findStreetName(id);
    }

    @Override
    public String findLineName(Integer id) {
        return changchunMapper.findLineName(id);
    }

    @Override
    public String findStationName(Integer id) {
        return changchunMapper.findStationName(id);
    }
}
