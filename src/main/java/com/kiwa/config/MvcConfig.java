package com.kiwa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hp
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /**
     * 不再为页面跳转单独创建一个controller方法
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/login").setViewName("system/login");
        registry.addViewController("/price/toPricePage").setViewName("price/priceList");
    }
}
