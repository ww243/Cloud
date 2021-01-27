package com.my.controller;

import com.my.entity.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/27 14:43
 */
@RestController
@RequestMapping("client02")
public class Client02Controller {

    private static final Logger log = LoggerFactory.getLogger(Client02Controller.class);

    //接受一个零散id类型参数   默认采用传统形式接受参数 url?id=22
    @GetMapping("text")
    public String text(@RequestParam("id")String id){
        log.info("接受到的id:{}",id);
        return id;
    }

    //接受一个零散id类型参数  使用restful传递参数方式
    @GetMapping("text1/{id}/{name}")
    public String text1(@PathVariable("id")String id,@PathVariable("name")String name){
        log.info("接受到的id:{},接受到的name:{}",id,name);
        return "id:"+id+"name:"+name;
    }

    //定义接受对象类型服务    //必须使用RequestBody进行标注,接受请求体中数据  将请求体中json数据自动转为对象
    @PostMapping("save")
    public Emp save(@RequestBody Emp emp){
        log.info("Emp:{}",emp);
        return emp;
    }

    //不接受任何参数 返回list
    @GetMapping("findAll")
    public List<Emp> findAll(){
        List<Emp> emps = new ArrayList<>();
        emps.add(new Emp("1","ljn",true,new Date()));
        emps.add(new Emp("2","cmy",true,new Date()));
        emps.add(new Emp("3","ymf",true,new Date()));
        return emps;
    }

    //@RequestBody  一般主要用来获取对象类型数据
    //@RequestPart  获取请求体数据含有文件数据
    //测试文件上传  consumes: 消费者  服务调用方给我提供必需是一个具有MULTIPART_FORM_DATA_VALUE的一个请求
    @PostMapping(value = "upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("ymf")MultipartFile multipartFile){
        log.info("文件名称: {}",multipartFile.getOriginalFilename());
        log.info("文件大小: {}",multipartFile.getSize());
        log.info("文件类型: {}",multipartFile.getContentType());
        return multipartFile.getOriginalFilename();
    }

}
