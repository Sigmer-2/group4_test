package com.zlk.group4.user.service;

import com.zlk.group4.user.entity.Role;
import com.zlk.group4.user.entity.UserPage;

import java.util.List;

public interface UserPageService {
    /**
     * @description:给user表分页
     * @author: sunjiahe
     * @param: [map]
     * @return: java.util.List<com.zlk.group4.user.entity.User>
     * @date: 2020/9/23 14:12
     **/
    List<UserPage> findUserList(Integer page, Integer limit);
    /**
     * @description:查询user表的行数
     * @author: sunjiahe
     * @param: []
     * @return: java.lang.Integer
     * @date: 2020/9/23 14:13
     **/
    Integer findUserCount();
    /**
     * @description:插入数据
     * @author: sunjiahe
     * @param: [user]
     * @return: java.lang.Integer
     * @date: 2020/9/23 14:14
     **/
    Integer saveUser0(UserPage user);
    /**
     * @description:删除数据
     * @author: sunjiahe
     * @param: [id]
     * @return: java.lang.Integer
     * @date: 2020/9/23 14:14
     **/
    Integer deleteUserById(Integer id);
    /**
     * @description:修改数据
     * @author: sunjiahe
     * @param: [user]
     * @return: java.lang.Integer
     * @date: 2020/9/23 14:14
     **/
    Integer updateUserById(UserPage user);
    /**
     * @description:根据id查询数据
     * @author: sunjiahe
     * @param: [id]
     * @return: java.util.List<com.zlk.group4.user.entity.User>
     * @date: 2020/9/23 14:14
     **/
    List<UserPage> findUserListById(Integer id);
    /**
     * @description:根据id查询user表的行数
     * @author: sunjiahe
     * @param: [id]
     * @return: java.lang.Integer
     * @date: 2020/9/23 14:15
     **/
    Integer findUserListByIdCount(Integer id);
    /**
     * @description:查询role表中的id和role_name
     * @author: sunjiahe
     * @param: []
     * @return: java.util.List<com.zlk.group4.user.entity.Role>
     * @date: 2020/9/23 17:04
     **/
    List<Role> findRoleIdAndName();


}
