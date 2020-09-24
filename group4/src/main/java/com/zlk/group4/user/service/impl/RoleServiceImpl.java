package com.zlk.group4.user.service.impl;

import com.zlk.group4.user.entity.Role;
import com.zlk.group4.user.mapper.RoleMapper;
import com.zlk.group4.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:sunjiahe
 * @date:2020/9/23
 * @descreption:
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleList(Integer page,Integer limit) {
        Map<String,Object> paraMap=new HashMap<String, Object>();
        Integer startIndex = (page-1)*limit;
        paraMap.put("startIndex",startIndex);
        paraMap.put("pageSize",limit);
        return roleMapper.findRoleList(paraMap);
    }

    @Override
    public Integer findRoleCount() {
        return roleMapper.findRoleCount();
    }

    @Override
    public Integer saveRole(Role role) {
        return roleMapper.saveRole(role);
    }

    @Override
    public Integer deleteRoleById(Integer id) {
        return roleMapper.deleteRoleById(id);
    }

    @Override
    public Integer updateRoleById(Role role) {
        return roleMapper.updateRoleById(role);
    }

    @Override
    public List<Role> findRoleListById(Integer id) {
        return roleMapper.findRoleListById(id);
    }

    @Override
    public Integer findRoleListByIdCount(Integer id) {
        return roleMapper.findRoleListByIdCount(id);
    }



}
