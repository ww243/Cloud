package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/27 14:32
 */
@SpringBootApplication
@EnableDiscoveryClient //consul client  zk  nacos 进行注册
@EnableFeignClients //开启feign
public class Client01Application {
    public static void main(String[] args) {
        SpringApplication.run(Client01Application.class,args);
    }
}
