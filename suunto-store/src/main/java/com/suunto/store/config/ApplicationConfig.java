package com.suunto.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zhangbing.xie
 * @Description：TODO 项目启动时 配置类添加拦截器,数据转换器，静态资源路径等
 * @date 2022-07-07 15:21
 **/
@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {


    /**
     * @Description 配置服务器跨域请求被允许
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
                .allowCredentials(true).maxAge(3600);
    }
}
