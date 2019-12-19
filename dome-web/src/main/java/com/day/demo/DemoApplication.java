package com.day.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Demo class
 *
 * @author leewebi-n
 * @date 2019/12/10
 */
@SpringBootApplication
@MapperScan("com.day.demo.mybatis.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
