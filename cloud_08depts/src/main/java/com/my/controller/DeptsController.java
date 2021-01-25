package com.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/25 14:54
 */
@RestController
@RequestMapping("depts")
public class DeptsController {

    private static final Logger log = LoggerFactory.getLogger(DeptsController.class);

    @Value("${server.port}")
    private int port;

    //resturl: http://localhost:7778/depts/21
    @GetMapping("{id}")
    public String dept(@PathVariable("id") String id)throws Exception{
        log.info("id:{}",id);
        TimeUnit.SECONDS.sleep(2);
        return "当前提供部门服务的端口是:"+port+" 本次查询id:"+id;
    }
}
