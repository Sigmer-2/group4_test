package com.zlk.group4.user.mapper;

import com.zlk.group4.repair.entity.WxRepair;
import com.zlk.group4.user.entity.MerchantUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: 
 * User: lihongying
 * Date: 2020-09-27
 * Time: 18:41
 */
@Mapper
public interface MerchantUserMapper {


    /**
     * 新增商户信息
     * @param record the record
     * @return insert count
     */
    int insertSelective(MerchantUser record);

    /**通过id查询商户信息
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    List<MerchantUser> selectMerchantUser(Integer id);
}