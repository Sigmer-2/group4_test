package com.zlk.group4.service;

import com.zlk.group4.entity.User;

/**
 * 用户相关操作方法的接口
 *
 * @className: UserService
 * @package: com.zlk.group4.service
 * @author: zhc
 * @date: 2020/9/22 11:06
 */
public interface UserService {
    /**
     *
     *查询数据库中是否有用户登录数据
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/8/17 10:36
     */
    Integer selectUserLogin(User user);
    /**
     *
     *查询数据库中是否有此用户名
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/8/17 14:55
     */
    Integer selectUserByName(String username);
    /**
     *
     *保存用户
     * @description: *
     * @param user
     * @return:
     * @author: zhc
     * @time: 2020/8/17 11:34
     */
    Integer saveUser(User user);
    /**
     *
     *获取用户的角色属性以决定后台页面的跳转
     * @description: * @param null
     * @return:
     * @author: zhc
     * @time: 2020/9/22 15:31
     */
    Integer findUserRole(User user);
}
