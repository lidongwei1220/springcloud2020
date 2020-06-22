package com.example.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 李东薇
 * @date 2020/6/17 10:11
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myRule() {
        //定义为随机机制
        return new RandomRule();
    }
}
