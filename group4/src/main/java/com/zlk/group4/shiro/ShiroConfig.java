package com.zlk.group4.shiro;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 *
 * shiro 相关配置
 * @description: * @param null
 * @return:
 * @author: zhc
 * @time: 2020/10/12 16:25
 */
@Configuration
public class ShiroConfig {

    //1.创建shiroFilter   负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统公共资源
        //配置系统受限资源
        Map<String,String> map=new HashMap<String,String>();
        map.put("/login", "anon");
        map.put("/register", "anon");
        map.put("/home", "authc");
        map.put("/user/logout","logout");
        map.put("/main", "authc");
        map.put("/houseForAdmin", "authc");
        map.put("/report", "authc");
        map.put("/repair", "authc");
        map.put("/question", "authc");
        map.put("/user", "authc");
        map.put("/role", "authc");
       // map.put("/**","authc");//authc 请求这个资源需要认证和授权

        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/login");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;
    }

    //3.创建自定义realm
    @Bean
    public Realm getRealm(){
        UserRealm customerRealm = new UserRealm();
        //修改凭证校验匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法为MD5
        credentialsMatcher.setHashAlgorithmName("md5");
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        return customerRealm;
    }
}
