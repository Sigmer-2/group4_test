package com.zlk.group4.house.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.zlk.group4.house.entity.House;
import com.zlk.group4.house.entity.HouseIdParam;
import com.zlk.group4.vo.HouseMsg;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 11:46
 */

public interface HouseService {


    int deleteByPrimaryKey(Integer id);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> selectAll();

    House selectAllById(Integer id);
    /**
     * 管理员查询房屋信息
     *
     * @description: *
     * @param map,page,limit
     * @return: List<house>
     * @author: zhc
     * @time: 2020/9/27 13:07
     */
    List<House> adminManageHouse(Map map,Integer page,Integer limit);
/**
 *
 * 管理员查询房屋总数
 * @description: *
 * @param
 * @return: num
 * @author: zhc
 * @time: 2020/9/27 13:08
 */
    Integer findHouseCount();
    /**
     * 模糊查询
     * 通过区域查询
     * @description: *
     * @param data
     * @return:
     * @author: zhc
     * @time: 2020/9/28 10:48
     */
    List<House> findHouseByRegion(String data);
    /**
     * 模糊查询
     * 通过地铁查询
     * @description: *
     * @param data
     * @return:
     * @author: zhc
     * @time: 2020/9/28 10:48
     */
    List<House> findHouseByMetro(String data);
    /**
     * 模糊查询
     * 通过月租金查询
     * @description: *
     * @param data
     * @return:
     * @author: zhc
     * @time: 2020/9/28 10:48
     */
    List<House> findHouseByRent(BigDecimal data);
    /**
     * 模糊查询
     * 通过房源类型查询
     * @description: *
     * @param data
     * @return:
     * @author: zhc
     * @time: 2020/9/28 10:48
     */
    List<House> findHouseByHouseType(String data);
    /**
     * 模糊查询
     * 通过出租类型查询
     * @description: *
     * @param data
     * @return:
     * @author: zhc
     * @time: 2020/9/28 10:48
     */
    List<House> findHouseByRentalModel(String data);
    /**
     *
     * 管理员删除单条房屋信息
     * @description: *
     * @param id
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:37
     */
    Integer adminDeleteHouseById(Integer id);
    /**
     *
     * 管理员删除多条房屋信息
     * @description: *
     * @param param
     * @return:
     * @author: zhc
     * @time: 2020/9/28 16:37
     */
    Integer adminDeleteHouseByIds(HouseIdParam param);
    /**
     *
     * 管理员对房屋信息进行修改
     * @description: *
     * @param house
     * @return:
     * @author: zhc
     * @time: 2020/9/29 19:12
     */
    Integer adminUpdateHouseById(House house);
    /**
     * 根据房源id查询房源信息集合
     * @Auther sunshuai
     * @Date 2020/10/8 9:43
     * @param houseId
     * @return
     */
    Map<String,Object> findHouseInfoById(Integer houseId);

    /**
     *
     * 小程序对房屋的查询
     * @description: *
     * @param map,page,limit
     * @return:
     * @author: zhc
     * @time: 2020/10/10 14:20
     */
    List<House> wxSelectHouse(Map map,Integer page,Integer limit);
}


