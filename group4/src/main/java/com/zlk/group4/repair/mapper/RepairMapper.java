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
    /**
     *查询所有报修信息
     * @author: wujian
     * @Date: 2020/10/1 14:56
     * @PARAM:[map]
     * @return: java.util.List<com.zlk.group4.repair.entity.Repair>
     */
    List<Repair> findAllRepair(Map map);
    /**
     *查询报修数量
     * @author: wujian
     * @Date: 2020/10/1 14:57
     * @PARAM:[]
     * @return: java.lang.Integer
     */
    Integer findRepairCount();
    /**
     *更新审核状态
     * @author: wujian
     * @Date: 2020/10/1 14:58
     * @PARAM:[id]
     * @return: java.lang.Integer
     */
    Integer updateRepairById(Integer id);
    /**
     *根据用户查询报修记录
     * @author: wujian
     * @Date: 2020/10/1 14:59
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.repair.entity.Repair>
     */
    List<Repair> selectRepairByUser(String data);
    /**
     *根据房屋查询报修记录
     * @author: wujian
     * @Date: 2020/10/1 14:59
     * @PARAM:[data]
     * @return: java.util.List<com.zlk.group4.repair.entity.Repair>
     */
    List<Repair> selectRepairByHouse(String data);
}
