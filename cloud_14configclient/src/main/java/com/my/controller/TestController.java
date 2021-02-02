package com.my.controller;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/31 21:17
 */
@RestController
@RequestMapping("text")
@RefreshScope //远端配置更新之后立即更新当前运行class中配置信息
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Value("${name}")
    private String name;

    @RequestMapping("text")
    public String text(){
        log.info("text......");
        log.info("name:{}",name);
        return "ok "+name;
    }
}
