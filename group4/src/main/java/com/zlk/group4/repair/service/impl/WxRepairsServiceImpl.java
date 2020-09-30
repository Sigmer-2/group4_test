package com.zlk.group4.repair.service.impl;

import com.zlk.group4.util.MyDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.repair.entity.WxRepair;
import com.zlk.group4.repair.mapper.WxRepairsMapper;
import com.zlk.group4.repair.service.WxRepairsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: lihongying
 * Date: 2020-09-27
 * Time: 21:42
 */
@Service
public class WxRepairsServiceImpl implements WxRepairsService {

    @Resource
    private WxRepairsMapper wxRepairsMapper;

    @Autowired
    private WxRepairsService wxRepairsService;

    @Override
    public int insertRepairs(WxRepair record) {
        return wxRepairsMapper.insertRepairs(record);
    }


    @Override
    public WxRepair findRepairsByUserid(Integer repairUserid) {
        return wxRepairsMapper.findRepairsByUserid(repairUserid);
    }

    @Override
    public List<WxRepair> selectLocationByUserId(Integer repairUserid) {
        return wxRepairsMapper.selectLocationByUserId(repairUserid);
    }


}
