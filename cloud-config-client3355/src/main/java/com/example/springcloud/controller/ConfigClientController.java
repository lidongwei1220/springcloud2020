package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李东薇
 * @date 2020/6/22 9:49
 */
@RestController
@RefreshScope     //发送(curl -X POST"http://localhost:3355/actuator/refresh")刷新，不需要重启
public class ConfigClientController {

//    @Value("${config.info}")
//    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "configInfo";
    }
}
