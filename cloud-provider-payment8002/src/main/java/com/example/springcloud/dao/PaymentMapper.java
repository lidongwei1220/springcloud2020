package com.example.springcloud.dao;

import com.example.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 李东薇
 * @date 2020/6/15 14:56
 */

@Mapper
public interface PaymentMapper {

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
    Payment getPayment(@Param("id") Long id);
}
