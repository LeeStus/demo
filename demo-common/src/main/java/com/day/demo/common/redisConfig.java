package com.day.demo.common;

import com.day.demo.Utils.ObjectRedisSerializerUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @project_name：
 * @classname：
 * @description:
 * @author: leewebi-n
 * @version: 0.1
 * @date:
 */
@Configuration
public class redisConfig {

    @Bean
    public RedisTemplate<Serializable, Object> restTemplate(RedisConnectionFactory connectionFactory){

        RedisTemplate<Serializable,Object> template = new RedisTemplate<Serializable,Object>();
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();
        //redis存取对象的关键配置
        template.setKeySerializer(new StringRedisSerializer());
        //ObjectRedisSerializer类为Java对象的序列化和反序列化工具类
        template.setValueSerializer(new ObjectRedisSerializerUtil());

        return template;
    }
}