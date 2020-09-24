package com.zlk.group4.user.service;

import com.zlk.group4.user.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    /**
     * @description:给role表分页
     * @author: sunjiahe
     * @param: [page, limit]
     * @return: java.util.List<com.zlk.group4.user.entity.Role>
     * @date: 2020/9/24 10:11
     **/
    List<Role> findRoleList(Integer page,Integer limit);
    /**
     * @description:查询role表的行数
     * @author: sunjiahe
     * @param: []
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:12
     **/
    Integer findRoleCount();
    /**
     * @description:插入数据
     * @author: sunjiahe
     * @param: [role]
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:12
     **/
    Integer saveRole(Role role);
    /**
     * @description:删除数据
     * @author: sunjiahe
     * @param: [id]
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:12
     **/
    Integer deleteRoleById(Integer id);
    /**
     * @description:修改数据
     * @author: sunjiahe
     * @param: [role]
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:12
     **/
    Integer updateRoleById(Role role);
    /**
     * @description:根据id查询数据
     * @author: sunjiahe
     * @param: [id]
     * @return: java.util.List<com.zlk.group4.user.entity.Role>
     * @date: 2020/9/24 10:12
     **/
    List<Role> findRoleListById(Integer id);
    /**
     * @description:查询固定id数据的行数
     * @author: sunjiahe
     * @param: [id]
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:13
     **/
    Integer findRoleListByIdCount(Integer id);


}
