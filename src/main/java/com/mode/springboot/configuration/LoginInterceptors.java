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
        //ע��UserInterceptor������
        InterceptorRegistration registration = registry.addInterceptor(new UserInterceptor());
        //����·����������
        registration.addPathPatterns("/**");
        //��Ӳ�����·��
        registration.excludePathPatterns("/views/login",
                "/views/register",
                "/toLogin");
    }
}
