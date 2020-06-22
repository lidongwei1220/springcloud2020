package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 李东薇
 * @date 2020/6/17 16:46
 */
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("consumer/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPayment(id);
    }
}
