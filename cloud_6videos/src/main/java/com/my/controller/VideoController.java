package com.my.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:ljn
 * @Description:
 * @Date:2021/01/21 17:49
 */
@RestController
@RequestMapping("videos")
public class VideoController {

    private static final Logger log = LoggerFactory.getLogger(VideoController.class);

    @GetMapping
    public String findAll(){
        log.info("进入视频的findALl！！！");
        return "videos findAll yes !";
    }
}
