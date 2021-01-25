package com.my.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/25 15:01
 */
@FeignClient("depts")
public interface DeptsClients {

    @GetMapping("/depts/{id}")
    public String dept(@PathVariable("id") String id);

}
