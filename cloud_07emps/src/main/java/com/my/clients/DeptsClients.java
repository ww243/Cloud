package com.my.clients;

import com.my.fallbacks.DeptFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/25 15:01
 */
//fallback用来指定当服务不可用时备选处理的类对象
@FeignClient(value = "depts",fallback = DeptFallBack.class)
public interface DeptsClients {

    @GetMapping("/depts/{id}")
    public String dept(@PathVariable("id") String id);

}
