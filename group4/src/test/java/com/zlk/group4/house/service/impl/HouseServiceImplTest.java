package com.zlk.group4.house.service.impl;


import com.zlk.group4.house.entity.HouseRefLabel;
import com.zlk.group4.house.service.HouseRefDeployService;
import com.zlk.group4.house.service.HouseRefImgService;
import com.zlk.group4.house.service.HouseRefLabelService;
import com.zlk.group4.house.service.HouseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



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
  @Test
  public void selectAll() {
    System.out.println(1);
    //    System.out.println(houseRefDeployService.selectDeployByHouseId(1));
      HouseRefLabel houseRefLabel = houseRefLabelService.selectLabelByHouseId(1);
      System.out.println(houseRefLabel);
    System.out.println(houseRefLabel.getHouseLabelId());

    //    System.out.println(houseRefImgService.selectImgByHouseId(1));
    System.out.println(houseRefLabelService.label(1));
  }
}