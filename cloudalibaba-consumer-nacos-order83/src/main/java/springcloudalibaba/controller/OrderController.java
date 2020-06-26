package springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springcloudalibaba.config.MyRestTemplate;

import javax.annotation.Resource;

/**
 * @author 李东薇
 * @date 2020/6/26 14:45
 */
@RestController
public class OrderController {

    @Resource
    private MyRestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("consumer/payment/nacos/{id}")
    public String getServerPort(@PathVariable String id) {
        return restTemplate.getRestTemplate().getForObject(serviceUrl +"/payment/nacos/"+id, String.class);
    }
}
