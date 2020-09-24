package com.zlk.group4.user.mapper;

import com.zlk.group4.user.entity.Role;
import com.zlk.group4.user.entity.UserPage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface RoleMapper {
    /**
     * @description:给role表分页
     * @author: sunjiahe
     * @param: [map]
     * @return: java.util.List<com.zlk.group4.user.entity.Role>
     * @date: 2020/9/24 10:07
     **/
    List<Role> findRoleList(Map map);
    /**
     * @description:查询role表的行数
     * @author: sunjiahe
     * @param: []
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:07
     **/
    Integer findRoleCount();
    /**
     * @description:插入数据
     * @author: sunjiahe
     * @param: [role]
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:08
     **/
    Integer saveRole(Role role);
    /**
     * @description:删除数据
     * @author: sunjiahe
     * @param: [id]
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:08
     **/
    Integer deleteRoleById(Integer id);
    /**
     * @description:修改数据
     * @author: sunjiahe
     * @param: [role]
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:08
     **/
    Integer updateRoleById(Role role);
    /**
     * @description:根据id查询数据
     * @author: sunjiahe
     * @param: [id]
     * @return: java.util.List<com.zlk.group4.user.entity.Role>
     * @date: 2020/9/24 10:09
     **/
    List<Role> findRoleListById(Integer id);
    /**
     * @description:查询固定id数据的行数
     * @author: sunjiahe
     * @param: [id]
     * @return: java.lang.Integer
     * @date: 2020/9/24 10:10
     **/
    Integer findRoleListByIdCount(Integer id);


}
