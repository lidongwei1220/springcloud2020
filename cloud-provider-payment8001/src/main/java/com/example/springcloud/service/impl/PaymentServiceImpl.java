package com.example.springcloud.service.impl;

import com.example.springcloud.dao.PaymentMapper;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 李东薇
 * @date 2020/6/15 15:32
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int savePayment(Payment payment) {
        return paymentMapper.savePayment(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentMapper.getPayment(id);
    }
}
