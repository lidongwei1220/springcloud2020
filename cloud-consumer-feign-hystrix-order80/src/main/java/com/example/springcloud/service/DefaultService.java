package com.example.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author 李东薇
 * @date 2020/6/18 19:50
 */
@Component
public class DefaultService implements OrderService {

    @Override
    public String returnOk(Integer id) {
        return "-----CLOUD-HYSTRIX-PAYMENT-SERVICE：服务器错误----";
    }

    @Override
    public String returnTimeOut(Integer id) {
        return "-----CLOUD-HYSTRIX-PAYMENT-SERVICE：服务器错误----";
    }
}
