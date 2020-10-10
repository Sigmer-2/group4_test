package com.zlk.group4.house.service.impl;


import com.zlk.group4.house.entity.HouseRefLabel;
import com.zlk.group4.house.mapper.HouseMapper;
import com.zlk.group4.house.service.*;
import com.zlk.group4.util.MyDateUtils;
import com.zlk.group4.util.MyHouseUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-09-23
 * Time: 13:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HouseServiceImplTest {
    @Autowired
    private HouseService houseService;
    @Autowired
    private HouseRefDeployService houseRefDeployService;

    @Autowired
    private HouseRefLabelService houseRefLabelService;

    @Autowired
    private HouseRefImgService houseRefImgService;

    @Autowired
    private HouseRefUserService refUserService;

    @Autowired
    private HouseLabelService labelService;

    @Resource
    private HouseMapper houseMapper;
  @Test
  public void selectAll() {
    System.out.println(1);
    //    System.out.println(houseRefDeployService.selectDeployByHouseId(1));
      HouseRefLabel houseRefLabel = houseRefLabelService.selectLabelByHouseId(1);
      System.out.println(houseRefLabel);
    System.out.println(houseRefLabel.getHouseLabelId());
      Map map = new HashMap();

    //    System.out.println(houseRefImgService.selectImgByHouseId(1));
    //    System.out.println(houseRefLabelService.label(1));
    //    System.out.println(houseRefDeployService.houseDeploy(1));
    //    System.out.println(refUserService.selectHouseByUserId(1));
//    System.out.println(refUserService.listAllByUserId(1));
      /*List<House> houses = houseMapper.adminManageHouse(map);
      System.out.println(houses);*/
//      labelService.insertHouseLabelByString("可短租，月付，无中介费，独卫，电梯房，带飘窗");//1,1,0,1,1,0,1,1,0
      /*HouseSexEnum man = HouseSexEnum.getHouseSex("仅限男");
      int code = man.getCode();
      System.out.println(man+"   "+code);*/
      try {
          Date parse = MyDateUtils.parse("2020-01-02", null);
      System.out.println(parse);
          String format = MyDateUtils.format(parse, "yyyy-MM-dd");
      System.out.println(format);
      } catch (ParseException e) {
          e.printStackTrace();
      }
  }
  @Test
  public void ss(){
        String str1 = "床,WIFI,空调,衣柜,书桌";
      String str2=",";
      Map<String, Object> deploys1 = MyHouseUtils.getDeploys(str1);
      Map<String, Object> deploys = MyHouseUtils.getDeploys(str2);
    System.out.println(deploys1);
    System.out.println(deploys);
  }
}