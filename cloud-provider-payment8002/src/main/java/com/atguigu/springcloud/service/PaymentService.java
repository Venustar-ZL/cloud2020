package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @ClassName:
 * @Description:
 * @Date : 2020-09-27 22:35
 * @Author: ZhangLei
 * @Version: 1.0
 **/
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);

}
