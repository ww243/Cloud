package com.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/21 17:53
 */
@RestController
@RequestMapping("users")
public class UsersController {

    private static final Logger log = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    /**
     *@Description:使用RestTemplate+@LoadBalancer注解实现负载均衡调用
    */
    @GetMapping("restTemplate")
    public String restTemplate(){
        String forObject = this.restTemplate.getForObject("http://VIDEOS/videos", String.class);
        log.info("video 哇哦:{}",forObject);
        return "restTemplate yes!!!!!";
    }

    /**
     *@Description:使用loadBalancerClient调用
     *  注意:默认的负载均衡策略为轮询策略
    */
    @GetMapping("loadBalancerClient")
    public String loadBalancerClient(){
        //通过负载均衡选择一个服务实例
        ServiceInstance videos = loadBalancerClient.choose("videos");
        log.info("负载均衡:{}",videos.getUri());
        //调用服务
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(videos.getUri() + "/videos", String.class);
        log.info("video result:{}",forObject);
        return "loadBalancerClient yes !!!";
    }

    /**
     *@Description:使用discoveryClient调用
    */
    @GetMapping("discoveryClient")
    public String discoveryClient(){
        //根据服务名称获取一组列表
        List<ServiceInstance> videos = discoveryClient.getInstances("videos");
        for (ServiceInstance video : videos) {
            log.info("当前主机为:{}",video.getUri()) ;
        }
        RestTemplate template = new RestTemplate();
        String forObject = template.getForObject(videos.get(0).getUri() + "/videos", String.class);
        log.info("video result:{}",forObject);
        return "discoveryClient yes!!!";
    }

    /**
     *@Description:使用restTemplate方式直接调用
    */
    @GetMapping
    public String findAll(){
        log.info("进入用户的findAll!！！");
        //调用视频服务
        /*1.第一种调用方式restTemplate对象调用
               缺点:地址写死不利于维护  无法实现负载均衡
        */
        RestTemplate restTemplate = new RestTemplate();
        String template = restTemplate.getForObject("http://localhost:8666/videos", String.class);
        log.info("本地调用视频服务的结果为:{}",template);

        /*2.使用ribbon + restTemplate 完成负载均衡调用
            ribbon不需要额外引入 在consul client 默认包含ribbon的依赖

            (1) DiscoveryClient 服务发现客户端
            (1) LoadBalanceClient 负载均衡的客户端
        */


        return "users findAll yes !";
    }
}
