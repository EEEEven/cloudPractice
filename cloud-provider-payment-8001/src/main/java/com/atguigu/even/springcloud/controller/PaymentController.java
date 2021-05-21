package com.atguigu.even.springcloud.controller;

import com.atguigu.even.springcloud.entities.CommonResult;
import com.atguigu.even.springcloud.entities.Payment;
import com.atguigu.even.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author Even
 * @Date 2021/5/20 14:56
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private Integer serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.addPayment(payment);
        log.info("*****插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort: " + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value = "get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("nice");
        if (payment != null) {
            return new CommonResult(200, "查询成功, <(*￣▽￣*)/,serverPort:  " + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录,查询ID: " + id, null);
        }
    }

}
