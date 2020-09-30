package com.zlk.group4.repair.mapper;

import com.zlk.group4.repair.entity.Repair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName RepairMapper
 * @program: group4
 * @description: 报修功能mapper层接口
 * @author: wujian
 * @Date: 2020/9/24 11:02
 **/
@Mapper
public interface RepairMapper {
    List<Repair> findAllRepair(Map map);
    Integer findRepairCount();
    Integer updateRepairById(Integer id);
}
