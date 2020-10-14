package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Date : 2020-10-08 12:22
 * @Author: ZhangLei
 * @Version: 1.0
 **/
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstance);

}
