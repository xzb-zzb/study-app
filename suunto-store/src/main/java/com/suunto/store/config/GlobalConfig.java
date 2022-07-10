package com.suunto.store.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

/**
 * @author zhangbing.xie
 * @Description：TODO
 * @date 2022-07-07 15:08
 **/
@Configuration
public class GlobalConfig {
    /**
     * 将java对象与json格式相互转化
     */
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }

    @Bean
    public ExecutorService asyncExecutor() {
        // 定义线程池隔离
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(200);
        ThreadPoolExecutor fixedThreadPool = new ThreadPoolExecutor(10,30, 20, TimeUnit.MINUTES, queue, new ThreadPoolExecutor.CallerRunsPolicy());
        return fixedThreadPool;
    }
}
