package com.zlk.group4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: sunshuai
 * Date: 2020-10-09
 * Time: 9:30
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    // 访问路径如：http://localhost:8080/img/*.jpg
    // 其中img表示访问的前缀。"file:D:"是文件真实的存储路径
    registry.addResourceHandler("/img/**").addResourceLocations("file:E:/杂七杂八/16/group/group4/src/main/resources/static/houseimg/");
    }
}
