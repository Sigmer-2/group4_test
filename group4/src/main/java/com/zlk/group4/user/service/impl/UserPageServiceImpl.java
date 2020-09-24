package com.zlk.group4.user.service.impl;

import com.zlk.group4.user.entity.Role;
import com.zlk.group4.user.entity.UserPage;
import com.zlk.group4.user.mapper.UserPageMapper;
import com.zlk.group4.user.service.UserPageService;
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
public class UserPageServiceImpl implements UserPageService {
    @Autowired(required = false)
    private UserPageMapper userPageMapper;

    @Override
    public List<UserPage> findUserList(Integer page, Integer limit) {
        Map<String,Object> paraMap=new HashMap<String, Object>();
        Integer startIndex = (page-1)*limit;
        paraMap.put("startIndex",startIndex);
        paraMap.put("pageSize",limit);
        return userPageMapper.findUserList(paraMap);
    }

    @Override
    public Integer findUserCount() {
        return userPageMapper.findUserCount();
    }

    @Override
    public Integer saveUser0(UserPage user) {
        return userPageMapper.saveUser0(user);
    }

    @Override
    public Integer deleteUserById(Integer id) {
        return userPageMapper.deleteUserById(id);
    }

    @Override
    public Integer updateUserById(UserPage user) {
        return userPageMapper.updateUserById(user);
    }

    @Override
    public List<UserPage> findUserListById(Integer id) {
        return userPageMapper.findUserListById(id);
    }

    @Override
    public Integer findUserListByIdCount(Integer id) {
        return userPageMapper.findUserListByIdCount(id);
    }

    @Override
    public List<Role> findRoleIdAndName() {
        return userPageMapper.findRoleIdAndName();
    }

}
