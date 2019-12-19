package com.day.demo.service.impl;

import com.day.demo.service.redisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Set;

/**
 * @project_name：
 * @classname：
 * @description:
 * @author: leewebi-n
 * @version: 0.1
 * @date:
 */
@Service
public class redisTestServiceImpl implements redisTestService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public HashMap<String, String> getRedisTest() {
        Set<String> keys = redisTemplate.keys("*");
        HashMap<String,String> map = new HashMap<>();
        for(String key:keys){
            String value = redisTemplate.opsForValue().get(key);
            map.put(key,value);
        }

        return map;
    }
}