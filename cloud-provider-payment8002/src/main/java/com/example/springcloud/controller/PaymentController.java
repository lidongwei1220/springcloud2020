package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 李东薇
 * @date 2020/6/15 15:34
 */

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @PostMapping("save")
    public CommonResult savePayment(@RequestBody Payment payment) {
        int result = paymentService.savePayment(payment);
        log.info("插入结果"+result);
        if (result > 0) {
            return new CommonResult(200, "成功，服务端口：" + port, result);
        }else {
            return new CommonResult(444, "失败，服务端口：" + port,null);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Payment payment = paymentService.getPayment(id);
        log.info("查询结果"+payment);
        if (payment != null) {
            return new CommonResult(200, "成功，服务端口：" + port, payment);
        }else {
            return new CommonResult(400, "失败，服务端口：" + port,null);
        }
    }

    @GetMapping("get/discoveryClient")
    public Object getDiscoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String e : services) {
            log.info("e:" + e);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance s : instances){
            log.info("s:" + s);
        }
        return this.discoveryClient;
    }

    @GetMapping("get/port")
    public String getPort() {
        return port;
    }
}
