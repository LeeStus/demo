package com.day.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.day.demo.common.Constant;
import com.day.demo.common.exception.CustomizeException;
import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import com.day.demo.service.loginService;
import com.sun.org.apache.bcel.internal.classfile.ConstantClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @project_name：
 * @classname：
 * @description:
 * @author: leewebi-n
 * @version: 0.1
 * @date:
 */
@RestController
public class TestController {

    Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private loginService service;

    @PostMapping("/queryLogin")
    public ResultDTO<LoginDTO> queryLogin (@RequestBody LoginDTO loginDTO){
        ResultDTO<LoginDTO> resultDTO = service.queryLogin(loginDTO);
        log.info(">>>>>>>>>>-------------"+loginDTO);
        return resultDTO;
    }

    @PostMapping("/listAll")
    public ResultDTO<LoginDTO> listAll (){
        ResultDTO<LoginDTO> resultDTO = service.listALl();
        return resultDTO;
    }

    @PostMapping("/insertLogin")
    public ResultDTO<LoginDTO> insertLogin(@RequestBody LoginDTO loginDTO){
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<>();

        try {
            resultDTO = service.insertLogin(loginDTO);
            log.info("》》》》》》》》》》》》--------插入成功:"+loginDTO);
        }catch (CustomizeException e){
            resultDTO.setResultMessage(e.getMessage());
            resultDTO.setResultCode(Constant.FAILURE);
        }
        return resultDTO;
    }
}