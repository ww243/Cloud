package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/28 15:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);


        //jdk8.0
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        //获取区域时间
        System.out.println(ZonedDateTime.now());

    }
}
