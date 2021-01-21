package com.my.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/21 18:51
 */
@Configuration
public class BeansConfig {

    /**
     *@param:@LoadBalanced注解让工厂创建RestTemplate具有负载均衡的功能
    */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
