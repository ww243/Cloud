package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/21 17:42
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UsersApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class,args);
    }
}
