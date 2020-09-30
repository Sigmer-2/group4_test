package com.zlk.group4.user.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zlk.group4.user.mapper.MerchantUserMapper;
import com.zlk.group4.user.entity.MerchantUser;
import com.zlk.group4.user.service.MerchantUserService;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: lihongying
 * Date: 2020-09-27
 * Time: 18:41
 */
@Service
public class MerchantUserServiceImpl implements MerchantUserService{

    @Resource
    private MerchantUserMapper merchantUserMapper;

    @Override
    public int insertSelectiveMerchant(MerchantUser record) {
        return merchantUserMapper.insertSelective(record);
    }

    @Override
    public List<MerchantUser> selectMerchantUser(Integer id) {
        return merchantUserMapper.selectMerchantUser(id);
    }


}
