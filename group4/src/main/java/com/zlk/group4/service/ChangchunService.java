package com.zlk.group4.service;

import com.zlk.group4.entity.Area;
import com.zlk.group4.entity.Line;
import com.zlk.group4.entity.Station;
import com.zlk.group4.entity.Street;

import java.util.List;

/**
 * 包含长春全部的区域和街道、地铁线路和站点的Service
 *
 * @className: ChangchunService
 * @package: com.zlk.group4.service
 * @author: zhc
 * @date: 2020/9/29 11:54
 */
public interface ChangchunService {
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
     *
     * 根据区域id查询区域名称
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/10/10 11:38
     */
    String findAreaName(Integer id);
    /**
     *
     * 根据街道id查询街道名称
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/10/10 11:38
     */
    String findStreetName(Integer id);
    /**
     *
     * 根据线路id查询线路名称
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/10/10 11:38
     */
    String findLineName(Integer id);
    /**
     *
     * 根据站点id查询站点名称
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/10/10 11:38
     */
    String findStationName(Integer id);
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
