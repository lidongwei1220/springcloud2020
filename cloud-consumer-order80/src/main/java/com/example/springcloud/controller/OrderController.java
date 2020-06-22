package com.example.springcloud.controller;

import com.example.springcloud.config.ApplicationContextConfig;
import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李东薇
 * @date 2020/6/15 16:44
 */
@RestController
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("consumer/save")
    public CommonResult<Payment> savePayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/save", payment, CommonResult.class);
    }

    @GetMapping("consumer/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/get/"+id, CommonResult.class);
    }

    @GetMapping("get/discoveryClient")
    public Object getDiscoveryClient() {
        return this.discoveryClient;
    }

    @GetMapping("consumer/get/port")
    public String getPost() {

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance s = loadBalancer.instances(instances);
        return restTemplate.getForObject(s.getUri() + "/get/port", String.class);

    }
}
