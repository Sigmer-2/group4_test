package com.zlk.group4.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: tsh
 * @program: workspace
 * @Date: 2020/9/4 16:55
 **/
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }

    public static Object getBean(String beanName){
        Object bean = context.getBean(beanName);
        return bean;
    }
}
