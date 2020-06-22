package com.example.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.example.springcloud.service.PaymentService;
import com.google.protobuf.ServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.concurrent.TimeUnit;

/**
 * @author 李东薇
 * @date 2020/6/18 10:48
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String returnOk(Integer id) {

        return "线程池：" + Thread.currentThread().getName() + "id：" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "payment_default", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String returnTimeOut(Integer id) {
        int timeNum = 5/0;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "耗时：" + timeNum;
    }

    public String payment_default(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "系统繁忙！id：" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "fusing", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //开关
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求峰值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //窗口时长
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")  //错误率
    })
    public String fusingTest(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }

        String ii = IdUtil.randomUUID();
        return Thread.currentThread().getName() + "流水号为：" + ii;
    }
    public String fusing(Integer id) {
        return "id不能为负数, 请稍后再试";
    }

}
