package com.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/28 15:48
 */
//@Configuration
public class CustomerFilters implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(CustomerFilters.class);

    /**
     * exchange  request  response
     * GatewayFilterChain filterChain
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入全局的filters");
        if (exchange.getRequest().getQueryParams().get("username")!=null){
            log.info("放行请求！");
            return chain.filter(exchange);//放行请求
        }
        log.info("拒绝放行！");
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
