package com.my.fallbacks;

import com.my.clients.DeptsClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/26 20:16
 */
@Component
public class DeptFallBack implements DeptsClients {

    private static final Logger log = LoggerFactory.getLogger(DeptFallBack.class);

    @Override
    public String dept(String id) {
        log.info("降级之后的接受的id:{}",id);
        return "当前访问服务已经被降级";
    }
}
