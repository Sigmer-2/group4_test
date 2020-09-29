package com.zlk.group4.mapper;

import com.zlk.group4.entity.Area;
import com.zlk.group4.entity.Line;
import com.zlk.group4.entity.Station;
import com.zlk.group4.entity.Street;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 包含长春全部的区域和街道、地铁线路和站点的查询
 *
 * @className: ChangchunMapper
 * @package: com.zlk.group4.mapper
 * @author: zhc
 * @date: 2020/9/29 12:04
 */
@Mapper
public interface ChangchunMapper {
    /**
     *
     * 查询长春所有区域
     * @description: *
     * @param
     * @return:
     * @author: zhc
     * @time: 2020/9/29 12:00
     */
    List<Area> findAllArea();
    /**
     * 根据区域id查包含街道
     *
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/29 12:01
     */
    List<Street> findStreet(Integer id);
    /**
     *
     * 查询长春所有地铁线路
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/29 12:00
     */
    List<Line> findAllLine();
    /**
     * 根据线路id查包含站点
     *
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/29 12:01
     */
    List<Station> findStation(Integer id);

}
