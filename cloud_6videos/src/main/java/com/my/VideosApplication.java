package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/21 17:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class VideosApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideosApplication.class,args);
    }
}
