package com.yuan.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //spring applicationContext.xml
public class ConfigBean {

    //配置负载均衡实现RestTemplate
    //AvailabilityFilteringRule 会先过滤掉跳闸和发生故障的服务，，对剩下的进行轮训
    //RandomRule 随机
    //RetryRule 会先按照轮询获取服务
    //RoundRobinRule    轮询
    @Bean
    @LoadBalanced //robbin实现
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //设置随机方式获取服务
//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }



}
