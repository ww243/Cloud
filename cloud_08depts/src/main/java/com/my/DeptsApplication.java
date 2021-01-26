package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/25 14:55
 */
@SpringBootApplication
@EnableDiscoveryClient //用来注册consul client
@EnableFeignClients  //开启openfeign方式调用
@EnableCircuitBreaker  //用来开启断路器
public class DeptsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeptsApplication.class,args);
    }
}
