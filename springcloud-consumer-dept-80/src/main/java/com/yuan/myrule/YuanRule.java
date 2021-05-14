package com.yuan.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YuanRule {

    //返回自定义的负载均衡策略
    @Bean
    public IRule yuanDefintedRule(){
        return new YuanRandomRule();
    }


}
