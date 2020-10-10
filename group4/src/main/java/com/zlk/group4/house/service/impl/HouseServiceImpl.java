package com.zlk.group4.house.service.impl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zlk.group4.house.entity.HouseIdParam;
import com.zlk.group4.house.entity.HouseRefImg;
import com.zlk.group4.house.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.house.mapper.HouseMapper;
import com.zlk.group4.house.entity.House;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 11:46
 */

@Service
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseMapper houseMapper;

    @Autowired
    private HouseRefDeployService houseRefDeployService;

    @Autowired
    private HouseRefLabelService houseRefLabelService;

    @Autowired
    private HouseRefImgService houseRefImgService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private MetroService metroService;

    @Autowired
    private HouseDeployService deployService;

    @Autowired
    private HouseLabelService labelService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int deleteByPrimaryKey(Integer id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insert(House record) {
        return houseMapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int insertSelective(House record) {
        return houseMapper.insertSelective(record);
    }

    @Override
    public House selectByPrimaryKey(Integer id) {
        return houseMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKeySelective(House record) {
        return houseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = {Exception.class})
    public int updateByPrimaryKey(House record) {
        return houseMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<House> selectAll() {
        return houseMapper.selectAll();
    }

    @Override
    public House selectAllById(Integer id) {
        return houseMapper.selectAllById(id);
    }


    @Override
    public List<House> adminManageHouse(Map map,Integer page,Integer limit) {
        Integer startIndex = (page-1)*limit;
        map.put("startIndex",startIndex);
        map.put("pageSize",limit);
        return houseMapper.adminManageHouse(map);
    }
    @Override
    public List<House> wxSelectHouse(Map map,Integer page,Integer limit) {
        Integer startIndex = (page-1)*limit;
        map.put("startIndex",startIndex);
        map.put("pageSize",limit);
        return houseMapper.wxSelectHouse(map);
    }

    @Override
    public Integer findHouseCount() {
        return houseMapper.findHouseCount();
    }

    @Override
    public List<House> findHouseByRegion(String data) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("region",data);
        map1.put("metro","");
        map1.put("rent","");
        map1.put("houseType","");
        map1.put("rentalModel","");
        return houseMapper.adminFindHouse(map1);
    }

    @Override
    public List<House> findHouseByMetro(String data) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("metro",data);
        map1.put("region","");
        map1.put("rent","");
        map1.put("houseType","");
        map1.put("rentalModel","");
        return houseMapper.adminFindHouse(map1);
    }

    @Override
    public List<House> findHouseByRent(BigDecimal data) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("rent",data);
        map1.put("region","");
        map1.put("metro","");
        map1.put("houseType","");
        map1.put("rentalModel","");
        return houseMapper.adminFindHouse(map1);
    }

    @Override
    public List<House> findHouseByHouseType(String data) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("houseType",data);
        map1.put("region","");
        map1.put("metro","");
        map1.put("rent","");
        map1.put("rentalModel","");
        return houseMapper.adminFindHouse(map1);
    }

    @Override
    public List<House> findHouseByRentalModel(String data) {
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("rentalModel",data);
        map1.put("region","");
        map1.put("metro","");
        map1.put("rent","");
        map1.put("houseType","");
        return houseMapper.adminFindHouse(map1);
    }

    @Override
    public Integer adminDeleteHouseById(Integer id) {
        houseMapper.deleteRefUserById(id);
        houseMapper.deleteRefDeployById(id);
        houseMapper.deleteRefLabelById(id);
        return houseMapper.adminDeleteHouseById(id);
    }

    @Override
    public Integer adminDeleteHouseByIds(HouseIdParam param) {
        houseMapper.deleteRefUserByIds(param);
        houseMapper.deleteRefDeployByIds(param);
        houseMapper.deleteRefLabelByIds(param);
        return houseMapper.adminDeleteHouseByIds(param);
    }

    @Override
    public Integer adminUpdateHouseById(House house) {
        return houseMapper.adminUpdateHouseById(house);
    }

    @Override
    public Map<String, Object> findHouseInfoById(Integer houseId) {
        Map<String, Object> map = new HashMap<>();
        House house = houseMapper.selectAllById(houseId);
        List<HouseRefImg> houseRefImgs = houseRefImgService.selectImgByHouseId(houseId);
        map.put("house",house);
        map.put("img",houseRefImgs);
        return map;
    }
}

