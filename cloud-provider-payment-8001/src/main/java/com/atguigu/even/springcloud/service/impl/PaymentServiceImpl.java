package com.atguigu.even.springcloud.service.impl;

import com.atguigu.even.springcloud.dao.PaymentDao;
import com.atguigu.even.springcloud.entities.Payment;
import com.atguigu.even.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Even
 * @Date 2021/5/20 14:56
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
