package com.my.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/28 15:39
 */
//@Configuration
public class RotuerConfig {


    /**
     * java8  supplier  consumer  函数式接口: 接口中只有一个抽象方法 接口使用@FunctionalInterface
     * 使用java代码形式配置路由规则
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                //参数1: 路由的唯一标识  参数2:函数式接口 lambda 表达式实现 url:代表具体转达的地址
                .route("client01_router",r->r.path("/client01/**").uri("http://localhost:8987/"))
                .route("client02_router",r->r.path("/client02/**").uri("http://localhost:8988/"))
                .build();
    }
}
