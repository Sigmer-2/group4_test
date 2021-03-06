package com.zlk.group4.service.impl;

import com.zlk.group4.entity.User;
import com.zlk.group4.mapper.UserMapper;
import com.zlk.group4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author: zhc
 * @time: 2020/9/22 11:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public Integer selectUserLogin(User user) {
        return userMapper.selectUserLogin(user);
    }

    @Override
    public Integer selectUserByName(String username) {
        return userMapper.selectUserByName(username);
    }

    @Override
    public User selectUserByName1(String username) {
        return userMapper.selectUserByName1(username);
    }

    @Override
    public Integer saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public Integer findUserRole(User user) {
        return userMapper.findUserRole(user);
    }

    @Override
    public Integer insertFoot(Map map) {
        return userMapper.insertFoot(map);
    }
}
