package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:
 * @Description:
 * @Date : 2020-10-05 15:20
 * @Author: ZhangLei
 * @Version: 1.0
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    // 使用此注解赋予restTemplate负载均衡的能力
//    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
