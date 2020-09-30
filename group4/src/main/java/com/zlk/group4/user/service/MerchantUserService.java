package com.zlk.group4.user.service;

import com.zlk.group4.repair.entity.WxRepair;
import com.zlk.group4.user.entity.MerchantUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: lihongying
 * Date: 2020-09-27
 * Time: 18:41
 */
public interface MerchantUserService{

        /**
         * 新增商户信息
         * @Auther lihongying
         * @Date 2020/9/27 18:43
         * @param record
         * @return int
         */
    int insertSelectiveMerchant(MerchantUser record);

       /**
        * 通过id查询商户信息
        * @Auther lihongying
        * @Date 2020/9/29 12:18
        * @param id
        * @return com.zlk.group4.user.entity.MerchantUser
        */
        List<MerchantUser> selectMerchantUser(Integer id);

}
