package com.zlk.group4.house;

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
 * Date: 2020-09-22
 * Time: 15:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdinaryTest {


    @Autowired
    private HouseService houseService;
    @Test
    public void ss(){
    System.out.println(1);
    System.out.println(houseService.selectByPrimaryKey(1));
    }
}
