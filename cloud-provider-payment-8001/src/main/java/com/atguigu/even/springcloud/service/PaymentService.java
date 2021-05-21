package com.atguigu.even.springcloud.service;

import com.atguigu.even.springcloud.entities.Payment;

/**
 * @Author Even
 * @Date 2021/5/20 14:55
 */
public interface PaymentService {

    int addPayment(Payment payment);

    Payment getPaymentById(Long id);

}
