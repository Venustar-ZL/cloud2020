package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @Date : 2020-10-05 15:10
 * @Author: ZhangLei
 * @Version: 1.0
 **/
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info("serial[{}]", payment.getSerial());
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * 自定义负载均衡测试
     * @return
     */
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb() {
        List<ServiceInstance> isntancesList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (isntancesList == null || isntancesList.size() == 0) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(isntancesList);
        URI url = serviceInstance.getUri();
        return restTemplate.getForObject(url + "/payment/lb", String.class);
    }

}
