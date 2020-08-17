package com.mode.springboot.autoconfigure.configure;

import com.mode.springboot.configuration.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Configuration
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
