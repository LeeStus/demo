package com.day.demo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author leewebi-n
 */

@Configuration
public class ApiConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return  new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        //默认的是JDK提供http连接，需要的话可以//通过setRequestFactory方法替换为例如Apache HttpComponents、
        // Netty或//OkHttp等其它HTTP library
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //单位为ms
        factory.setReadTimeout(10000);
        //单位为ms
        factory.setConnectTimeout(10000);
        return factory;
    }
}
