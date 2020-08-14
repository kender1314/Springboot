package com.mode.springboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/8/13 23:10
 * @Description:
 */
@Configuration
public class LoginInterceptors implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //注册UserInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new UserInterceptor());
        //所有路径都被拦截
        registration.addPathPatterns("/**");
        //添加不拦截路径
        registration.excludePathPatterns("/toLogin");
    }
}
