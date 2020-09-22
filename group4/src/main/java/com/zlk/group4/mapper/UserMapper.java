package com.zlk.group4.mapper;

import com.zlk.group4.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 对用户相关的操作
 *
 * @className: UserMapper
 * @package: com.zlk.group4.mapper
 * @author: zhc
 * @date: 2020/9/22 11:06
 */
@Mapper
public interface UserMapper {
    /**
     *
     *查询数据库中是否有用户登录数据
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/8/16 22:30
     */
    Integer selectUserLogin(User user);
    /**
     *
     *查询数据库中是否有此用户名
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/8/17 14:57
     */
    Integer selectUserByName(String username);
    /**
     *
     *注册用户（保存）
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/8/17 11:37
     */
    Integer saveUser(User user);
}
