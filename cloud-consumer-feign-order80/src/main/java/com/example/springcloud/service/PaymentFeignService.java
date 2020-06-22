package com.example.springcloud.service;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 李东薇
 * @date 2020/6/17 16:43
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
