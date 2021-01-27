package com.my.client;

import com.my.entity.Emp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/27 14:49
 */
@FeignClient("client02")
public interface Clients02client {

    /**
     * 注意:通过openfeign传递url?id参数时，接受必须使用@RequestParam注解标识才可以
     * @param id
     * @return
     */
    @GetMapping("/client02/text")
    String text(@RequestParam("id")String id);

    /**
     * 使用restful方式传递参数
     * 注意:必须在接受参数位置加入@PathVariable
     * @param id
     * @param name
     * @return
     */
    @GetMapping("/client02/text1/{id}/{name}")
    String text1(@PathVariable("id")String id, @PathVariable("name")String name);

    //restful 传递对象
    @PostMapping("/client02/save")
    public Emp save(@RequestBody Emp emp);

    //查询所有
    @GetMapping("/client02/findAll")
    public List<Emp> findAll();

    //文件传递
    @PostMapping(value = "/client02/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String upload(@RequestPart("multipartFile")MultipartFile multipartFile);

}
