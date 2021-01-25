package com.my.controller;

import com.my.clients.DeptsClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/25 14:52
 */
@RestController
@RequestMapping("emps")
public class EmpsController {

    private static final Logger log = LoggerFactory.getLogger(EmpsController.class);
    @Autowired
    private DeptsClients deptsClients;

    @GetMapping("{id}")
    public String emp(@PathVariable("id") String id){
        log.info("id:{}",id);
        //完成部门服务调用 RestTemplate + ribbon  使用openfeign方式调用
        return deptsClients.dept(id);
    }


}
