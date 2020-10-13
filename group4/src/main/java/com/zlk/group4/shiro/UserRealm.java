package com.zlk.group4.shiro;


import com.zlk.group4.entity.User;
import com.zlk.group4.service.UserService;

import com.zlk.group4.util.ApplicationContextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Description: 自定义realm
 * @Author: tsh
 * @program: workspace
 * @Date: 2020/9/4 15:15
 **/
public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       // System.out.println("==============");
        String principal = (String) token.getPrincipal();
        //在工厂中获取service对象
        UserService sysUserService = (UserService) ApplicationContextUtils.getBean("userServiceImpl");
        User sysUser = sysUserService.selectUserByName1(principal);
        if(sysUser!=null){
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser.getUserName(),sysUser.getUserPassword(),this.getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
