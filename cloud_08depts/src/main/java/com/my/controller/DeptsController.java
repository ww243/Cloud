package com.my.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @HystrixCommand(fallbackMethod = "deptFallBack")
    //当断路器开启默认执行备选方案   fallbackMethod:用来指定当断路器打开的备选方法
    public String dept(@PathVariable("id") String id)throws Exception{
        log.info("id:{}",id);
        //TimeUnit.SECONDS.sleep(2);
        if(Integer.valueOf(id)<0) throw new RuntimeException("提示:无效id");
        return "当前提供部门服务的端口是:"+port+" 本次查询id:"+id;
    }

    @GetMapping
    @HystrixCommand(fallbackMethod = "deptsFallBack")
    public String depts(){
        return "查询部门的所有!";
    }


    public String defaultFallBack(){
        return "当前服务异常,默认的熔断处理方法";
    }

    public String deptsFallBack(){
        return "当前服务异常,已被熔断!";
    }


    public String deptFallBack(String id){
        System.out.println("id:"+id);
        return "当前服务异常,已被熔断!";
    }
}
