package com.atguigu.even.springcloud.controller;

import com.atguigu.even.springcloud.entities.CommonResult;
import com.atguigu.even.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author Even
 * @Date 2021/5/20 16:31
 */
@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://192.168.10.159:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

}
