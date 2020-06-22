package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 李东薇
 * @date 2020/6/18 10:59
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "get/ok/{id}")
    public String returnOk(@PathVariable("id") Integer id) {
        return paymentService.returnOk(id);
    }

    @GetMapping(value = "get/timeout/{id}")
    public String returnTimeOut(@PathVariable("id") Integer id) {
        return paymentService.returnTimeOut(id);
    }

    @GetMapping(value = "get/fusing/{id}")
    public String fusingTest(@PathVariable("id") Integer id) {
        return paymentService.fusingTest(id);
    }

    @GetMapping(value = "hi/hello")
    public String hello() {
        return "Hello word!";
    }
}
