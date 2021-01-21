package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/21 16:07
 */
@SpringBootApplication
@EnableDiscoveryClient //通用服务注册客户端注解
    // consul client  zk client  nacos client  eureka client
public class ConsulClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulClientApplication.class,args);
    }
}
