package com.example.springcloud.service;

/**
 * @author 李东薇
 * @date 2020/6/18 10:46
 */
public interface PaymentService {

    String returnOk(Integer id);

    String returnTimeOut(Integer id);

    String fusingTest(Integer id);
}
