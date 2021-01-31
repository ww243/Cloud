package com.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/31 21:17
 */
@RestController
@RequestMapping("text")
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);


    @RequestMapping("text")
    public String text(){
        log.info("text......");

        return "ok";
    }
}
