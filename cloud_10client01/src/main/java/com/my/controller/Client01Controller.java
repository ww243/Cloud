package com.my.controller;

import com.my.client.Clients02client;
import com.my.entity.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/27 14:35
 */
@RestController
@RequestMapping("client01")
public class Client01Controller {

    private static final Logger log = LoggerFactory.getLogger(Client01Controller.class);

    @Autowired
    private Clients02client clients02client;

    //测试文件传递
    @PostMapping("upload")
    public String upload(MultipartFile multipartFile){
        log.info("client01 接收到文件名称: {}",multipartFile.getOriginalFilename());
        return clients02client.upload(multipartFile);
    }

    //调用服务方查询所有返回集合
    @GetMapping("findAll")
    public List<Emp> findAll(){
        log.info("Client01的Emps的查询所有:{}",clients02client.findAll());
        return clients02client.findAll();
    }

    //spring 框架日期格式: 2012/12/12
    //对象与json之间转换: fastjson gson jackson(默认 支持日期:yyyy-MM-dd)
    @PostMapping("save")
    public Emp save(@RequestBody Emp emp){
        log.info("Client01中的Emp:{}",emp);
        return clients02client.save(emp);
    }

    @GetMapping("text1/{id}/{name}")
    public String text1(@PathVariable("id")String id, @PathVariable("name")String name){
        log.info("接受client01的id:{},接受client01的name:{}",id,name);
        return clients02client.text1(id, name);
    }

    //测试传递url?传递参数
    @GetMapping("text")
    public String text(String id){
        log.info("Client01接受到的id:",id);
        return clients02client.text(id);
    }
}
