package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName:
 * @Description:
 * @Date : 2020-10-07 22:09
 * @Author: ZhangLei
 * @Version: 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderZK80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZK80.class, args);
    }

}
