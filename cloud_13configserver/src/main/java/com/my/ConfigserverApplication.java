package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/31 19:21
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer //开启统一配置中心服务
public class ConfigserverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigserverApplication.class,args);
    }
}
