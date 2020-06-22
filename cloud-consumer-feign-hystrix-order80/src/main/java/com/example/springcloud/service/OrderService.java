package com.example.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 李东薇
 * @date 2020/6/18 15:54
 */
@Component
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE", fallback = DefaultService.class)
public interface OrderService {

    @GetMapping(value = "get/ok/{id}")
    public String returnOk(@PathVariable("id") Integer id);

    @GetMapping(value = "get/timeout/{id}")
    public String returnTimeOut(@PathVariable("id") Integer id);

}
