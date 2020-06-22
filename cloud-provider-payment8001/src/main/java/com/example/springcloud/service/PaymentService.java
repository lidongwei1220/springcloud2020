package com.example.springcloud.service;

import com.example.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 李东薇
 * @date 2020/6/15 15:31
 */
public interface PaymentService {


    /**
     * 增
     * @param payment
     */
    int savePayment(Payment payment);

    /**
     * 查
     * @param id
     * @return
     */
    Payment getPayment(Long id);
}
