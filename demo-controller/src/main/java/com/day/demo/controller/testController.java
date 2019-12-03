package com.day.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project_name：
 * @classname：
 * @description:
 * @author: leewebi-n
 * @version: 0.1
 * @date:
 */
@RestController
public class testController {

    Logger log = LoggerFactory.getLogger(testController.class);

    @PostMapping("/test")
    public String test(){



        log.info("日志记录");
        return "Dispatch servlet";
    }
}