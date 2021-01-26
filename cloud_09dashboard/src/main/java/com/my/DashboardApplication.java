package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/26 20:36
 */
@SpringBootApplication
@EnableHystrixDashboard //开启监控面板
public class DashboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class,args);
    }
}
