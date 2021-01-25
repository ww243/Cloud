package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/25 14:51
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EmpsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpsApplication.class,args);
    }
}
