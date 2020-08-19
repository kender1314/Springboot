package com.mode.springboot.autoconfigure.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Configuration
@EnableConfigurationProperties({CommonProperties.class})
@ComponentScan(basePackages={
        "com.mode.springboot.component",
        "com.mode.springboot.controller",
        "com.mode.springboot.dao",
        "com.mode.springboot.service",
        "com.mode.springboot.utils",
        "com.mode.springboot.support"})
public class CommonConfiguration {

    @Autowired
    private CommonProperties commonProperties;

    @Bean
    public UserInterceptor userInterceptor(){
        return new UserInterceptor(commonProperties);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
