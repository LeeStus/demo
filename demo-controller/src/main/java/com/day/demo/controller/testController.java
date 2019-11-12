package com.day.demo.controller;

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

    @GetMapping("/test")
    public String test(){

        return "Dispatch servlet";
    }
}