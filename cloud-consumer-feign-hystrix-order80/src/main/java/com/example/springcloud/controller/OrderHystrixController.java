package com.example.springcloud.controller;

import com.example.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 李东薇
 * @date 2020/6/18 15:57
 */
@RestController
@DefaultProperties(defaultFallback = "lDefault")
public class OrderHystrixController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "get/ok/{id}")
    public String returnOk(@PathVariable("id") Integer id) {
        return orderService.returnOk(id);
    }

    @GetMapping(value = "get/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "payment_default", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String returnTimeOut(Integer id) {
        int i = 1/0;
        return orderService.returnOk(id);
    }
    public String payment_default(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "支付系统繁忙！";
    }
    public String lDefault() {
        return "服务器异常";
    }
}
