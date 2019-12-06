package com.day.demo.controller.test;

import com.day.demo.service.redisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @project_name：redis
 * @classname：test
 * @description:
 * @author: leewebi-n
 * @version: 0.1
 * @date: 2019/12/5 15:11
 */
@RestController
public class redisTestController {

    @Autowired
    private redisTestService service;

    @PostMapping("/redis/getValue")
    private HashMap<String, String> getRedis(){


        return service.getRedisTest();
    }
}