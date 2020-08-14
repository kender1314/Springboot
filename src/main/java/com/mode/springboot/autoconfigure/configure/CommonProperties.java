package com.mode.springboot.autoconfigure.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.devtools.autoconfigure.DevToolsProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 注解说明：
 * NestedConfigurationProperty：当一个类中引用了外部类，需要在该属性上加该注解
 * ConfigurationProperties：配置application的路径
 * Primary：在spring 中使用注解，常使用@Autowired， 默认是根据类型Type来自动注入的。
 * 但有些特殊情况，对同一个接口，可能会有几种不同的实现类，而默认只会采取其中一种的情况下含有 @Primary 的。
 *
 * @Author jiang.he
 * @Version 1.0.0 RELEASE
 * @Date 2020/7/11 20:12
 * @Description:
 */
@Primary
@Component
@ConfigurationProperties("sb.common")
public class CommonProperties {

    /**
     * 是否开启过滤
     */
    private boolean interceptor = true;

    /**
     * 是否初始化数据，包含数据库中的数据初始化
     */
    private boolean initData = false;

    public boolean isInterceptor() {
        return interceptor;
    }

    public void setInterceptor(boolean interceptor) {
        this.interceptor = interceptor;
    }

    public boolean isInitData() {
        return initData;
    }

    public void setInitData(boolean initData) {
        this.initData = initData;
    }
}
