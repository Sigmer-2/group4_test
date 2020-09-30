package com.zlk.group4.house.controller;

import com.zlk.group4.entity.Area;
import com.zlk.group4.entity.Line;
import com.zlk.group4.entity.Station;
import com.zlk.group4.entity.Street;
import com.zlk.group4.house.entity.*;
import com.zlk.group4.house.service.*;
import com.zlk.group4.service.ChangchunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有关房屋信息的操作
 *
 * @author: zhc
 * @time: 2020/9/23 17:45
 */
@Controller
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseLabelService houseLabelService;
    @Autowired
    private HouseDeployService houseDeployService;
    @Autowired
    private HouseRefLabelService houseRefLabelService;
    @Autowired
    private HouseRefDeployService houseRefDeployService;
    @Autowired
    private HouseRefImgService houseRefImgService;
    @Autowired
    private HouseRefUserService houseRefUserService;
    @Autowired
    private ChangchunService changchunService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private MetroService metroService;

    /**
     * 获取所有房间信息
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:46
     */
    @RequestMapping(value = "/adminFindAllHouse", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> findHouseAll(Integer page, Integer limit) throws Exception {
        Map<String, Object> paraMap = new HashMap<String, Object>();
        List<House> houseList = houseService.adminManageHouse(paraMap, page, limit);
        for (House house : houseList) {
            Integer i = house.getHouseRefLabel().getId();
            house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
            house.getHouseRefLabel().setId(i);
            Integer j = house.getHouseRefDeploy().getId();
            house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
            house.getHouseRefDeploy().setId(j);
            house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
            house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
        }
        Integer count = houseService.findHouseCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", houseList);
        map.put("count", count);
        return map;
    }

    /**
     * 获取房间所包含的图片
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:46
     */
    @RequestMapping(value = "/findImgsByHouseId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findImgsByHouseId(Integer id) throws Exception {
        List<HouseRefImg> houseRefImgs = houseRefImgService.selectImgByHouseId(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", houseRefImgs);
        return map;
    }

    /**
     * 通过条件模糊查询
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:46
     */
    @RequestMapping(value = "/AdminfindHouseBy", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> AdminfindHouseBy(Integer select, String data) throws Exception {
        if (select == null) {
            select = 0;
        }
        System.out.println(select + " " + data);
        if (select == 0) {
            List<House> houseList = houseService.findHouseByRegion(data);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", houseList);
            return map;
        } else if (select == 1) {
            List<House> houseList = houseService.findHouseByMetro(data);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", houseList);
            return map;
        } else if (select == 2) {
            BigDecimal bd = new BigDecimal(data);
            List<House> houseList = houseService.findHouseByRent(bd);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", houseList);
            return map;
        } else if (select == 3) {
            List<House> houseList = houseService.findHouseByHouseType(data);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", houseList);
            return map;
        } else {
            List<House> houseList = houseService.findHouseByRentalModel(data);
            for (House house : houseList) {
                Integer i = house.getHouseRefLabel().getId();
                house.setHouseRefLabel(houseRefLabelService.selectLabelByHouseId(house.getId()));
                house.getHouseRefLabel().setId(i);
                Integer j = house.getHouseRefDeploy().getId();
                house.setHouseRefDeploy(houseRefDeployService.selectDeployByHouseId(house.getId()));
                house.getHouseRefDeploy().setId(j);
                house.setHouseRefImgs(houseRefImgService.selectImgByHouseId(house.getId()));
                house.setHouseRefUser(houseRefUserService.selectUserByHouseId(house.getId()));
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("data", houseList);
            return map;
        }
    }

    /**
     * 删除单条房间信息
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:45
     */
    @RequestMapping(value = "/adminDeleteHouseById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> adminDeleteHouseById(Integer id) throws Exception {
        Integer flag = houseService.adminDeleteHouseById(id);
        HashMap<String, Object> map = new HashMap<>();
        if (flag > 0) {
            map.put("msg", 1);
        } else {
            map.put("msg", 0);
        }
        return map;
    }

    /**
     * 多id删除房间信息及其关联表
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:45
     */
    @RequestMapping(value = "/adminDeleteHouseByIds", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> adminDeleteHouseByIds(@RequestBody HouseIdParam param) throws Exception {
        Integer flag = houseService.adminDeleteHouseByIds(param);
        HashMap<String, Object> map = new HashMap<>();
        if (flag > 0) {
            map.put("msg", 1);
        } else {
            map.put("msg", 0);
        }
        return map;
    }

    /**
     * 查找所有区域
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:45
     */
    @RequestMapping(value = "/findAllArea", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAllArea() throws Exception {
        List<Area> areaList = changchunService.findAllArea();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", areaList);
        return map;
    }

    /**
     * 查找区域所包含的街道
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:44
     */
    @RequestMapping(value = "/findStreetByAreaId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findStreetByAreaId(String id) throws Exception {
        List<Street> streetList = changchunService.findStreet(Integer.valueOf(id));
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", streetList);
        return map;
    }

    /**
     * 修改房间区域
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:44
     */
    @RequestMapping(value = "/adminUpdateRegion", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> adminUpdateRegion(@RequestBody Region region) throws Exception {
        Integer flag = regionService.adminUpdateRegion(region);
        HashMap<String, Object> map = new HashMap<>();
        if (flag > 0) {
            map.put("msg", 1);
        }
        return map;
    }

    /**
     * 查找所有线路
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:44
     */
    @RequestMapping(value = "/findAllLine", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findAllLine() throws Exception {
        List<Line> lineList = changchunService.findAllLine();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", lineList);
        return map;
    }

    /**
     * 查找线路所包含的站点
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:44
     */
    @RequestMapping(value = "/findStationByLineId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findStationByLineId(String id) throws Exception {
        List<Station> stationList = changchunService.findStation(Integer.valueOf(id));
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", stationList);
        return map;
    }

    /**
     * 修改房间地铁
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:43
     */
    @RequestMapping(value = "/adminUpdateMetro", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> adminUpdateMetro(@RequestBody Metro metro) throws Exception {
        Integer flag = metroService.adminUpdateMetro(metro);
        HashMap<String, Object> map = new HashMap<>();
        if (flag > 0) {
            map.put("msg", 1);
        }
        return map;
    }

    /**
     * 修改房间简介
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:43
     */
    @RequestMapping(value = "/adminUpdateHouseById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> adminUpdateHouseById(@RequestBody House house) throws Exception {
        Date dateNow = new Date();
        house.setUpdateTime(dateNow);
        Integer flag = houseService.adminUpdateHouseById(house);
        HashMap<String, Object> map = new HashMap<>();
        if (flag > 0) {
            map.put("msg", 1);
        }
        return map;
    }

    /**
     * 通过房间关联的标签id查询房间标签
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:42
     */
    @RequestMapping(value = "/findLabelByHouseLabelId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findLabelByHouseLabelId(Integer id) throws Exception {
        HouseLabel houseLabel = houseLabelService.selectByPrimaryKey(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", houseLabel);
        return map;
    }

    /**
     * 修改房间标签
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:42
     */
    @RequestMapping(value = "/adminUpdateHouseLabel", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> adminUpdateHouseLabel(Integer id, Integer[] ids) throws Exception {
        HouseLabel houseLabel = new HouseLabel();
        houseLabel.setId(id);
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                if (ids[i] == 1) {
                    houseLabel.setShortRent(1);
                }
                if (ids[i] == 2) {
                    houseLabel.setPayment(1);
                }
                if (ids[i] == 3) {
                    houseLabel.setSouthward(1);
                }
                if (ids[i] == 4) {
                    houseLabel.setAgencyfee(1);
                }
                if (ids[i] == 5) {
                    houseLabel.setToilet(1);
                }
                if (ids[i] == 6) {
                    houseLabel.setBalcony(1);
                }
                if (ids[i] == 7) {
                    houseLabel.setElevator(1);
                }
                if (ids[i] == 8) {
                    houseLabel.setBayWindow(1);
                }
                if (ids[i] == 9) {
                    houseLabel.setDecoration(1);
                }

            }
        }

        if (houseLabel.getShortRent() == null) {
            houseLabel.setShortRent(0);
        }
        if (houseLabel.getPayment() == null) {
            houseLabel.setPayment(0);
        }
        if (houseLabel.getSouthward() == null) {
            houseLabel.setSouthward(0);
        }
        if (houseLabel.getAgencyfee() == null) {
            houseLabel.setAgencyfee(0);
        }
        if (houseLabel.getToilet() == null) {
            houseLabel.setToilet(0);
        }
        if (houseLabel.getBalcony() == null) {
            houseLabel.setBalcony(0);
        }
        if (houseLabel.getElevator() == null) {
            houseLabel.setElevator(0);
        }
        if (houseLabel.getBayWindow() == null) {
            houseLabel.setBayWindow(0);
        }
        if (houseLabel.getDecoration() == null) {
            houseLabel.setDecoration(0);
        }
        Integer flag = houseLabelService.updateByPrimaryKeySelective(houseLabel);
        HashMap<String, Object> map = new HashMap<>();
        if (flag > 0) {
            map.put("msg", 1);
        }
        return map;
    }

    /**
     * 查询房间配置通过房间关联的配置id
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:41
     */
    @RequestMapping(value = "/findDeployByHouseDeployId", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> findDeployByHouseDeployId(Integer id) throws Exception {
        HouseDeploy houseDeploy = houseDeployService.selectByPrimaryKey(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", houseDeploy);
        return map;
    }

    /**
     * 修改房间配置
     *
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/30 4:41
     */
    @RequestMapping(value = "/adminUpdateHouseDeploy", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> adminUpdateHouseDeploy(Integer id, Integer[] ids) throws Exception {
        HouseDeploy houseDeploy = new HouseDeploy();
        houseDeploy.setId(id);
        if (ids != null) {
            for (int i = 0; i < ids.length; i++) {
                if (ids[i] == 1) {
                    houseDeploy.setBed(1);
                }
                if (ids[i] == 2) {
                    houseDeploy.setWifi(1);
                }
                if (ids[i] == 3) {
                    houseDeploy.setConditioner(1);
                }
                if (ids[i] == 4) {
                    houseDeploy.setWardrobe(1);
                }
                if (ids[i] == 5) {
                    houseDeploy.setDesk(1);
                }
                if (ids[i] == 6) {
                    houseDeploy.setChair(1);
                }
                if (ids[i] == 7) {
                    houseDeploy.setSofa(1);
                }
                if (ids[i] == 8) {
                    houseDeploy.setRefrigerator(1);
                }
                if (ids[i] == 9) {
                    houseDeploy.setWashing(1);
                }
                if (ids[i] == 10) {
                    houseDeploy.setTv(1);
                }
                if (ids[i] == 11) {
                    houseDeploy.setHeater(1);
                }
                if (ids[i] == 12) {
                    houseDeploy.setStove(1);
                }
                if (ids[i] == 13) {
                    houseDeploy.setMicrowave(1);
                }
                if (ids[i] == 14) {
                    houseDeploy.setLampblack(1);
                }
                if (ids[i] == 15) {
                    houseDeploy.setDining(1);
                }
                if (ids[i] == 16) {
                    houseDeploy.setLock(1);
                }
                if (ids[i] == 17) {
                    houseDeploy.setLed(1);
                }
            }
        }

        if (houseDeploy.getBed() == null) {
            houseDeploy.setBed(0);
        }
        if (houseDeploy.getWifi() == null) {
            houseDeploy.setWifi(0);
        }
        if (houseDeploy.getConditioner() == null) {
            houseDeploy.setConditioner(0);
        }
        if (houseDeploy.getWardrobe() == null) {
            houseDeploy.setWardrobe(0);
        }
        if (houseDeploy.getDesk() == null) {
            houseDeploy.setDesk(0);
        }
        if (houseDeploy.getChair() == null) {
            houseDeploy.setChair(0);
        }
        if (houseDeploy.getSofa() == null) {
            houseDeploy.setSofa(0);
        }
        if (houseDeploy.getRefrigerator() == null) {
            houseDeploy.setRefrigerator(0);
        }
        if (houseDeploy.getWashing() == null) {
            houseDeploy.setWashing(0);
        }
        if (houseDeploy.getTv() == null) {
            houseDeploy.setTv(0);
        }
        if (houseDeploy.getHeater() == null) {
            houseDeploy.setHeater(0);
        }
        if (houseDeploy.getStove() == null) {
            houseDeploy.setStove(0);
        }
        if (houseDeploy.getMicrowave() == null) {
            houseDeploy.setMicrowave(0);
        }
        if (houseDeploy.getLampblack() == null) {
            houseDeploy.setLampblack(0);
        }
        if (houseDeploy.getDining() == null) {
            houseDeploy.setDining(0);
        }
        if (houseDeploy.getLock() == null) {
            houseDeploy.setLock(0);
        }
        if (houseDeploy.getLed() == null) {
            houseDeploy.setLed(0);
        }
        Integer flag = houseDeployService.updateByPrimaryKeySelective(houseDeploy);
        HashMap<String, Object> map = new HashMap<>();
        if (flag > 0) {
            map.put("msg", 1);
        }
        return map;
    }
}
