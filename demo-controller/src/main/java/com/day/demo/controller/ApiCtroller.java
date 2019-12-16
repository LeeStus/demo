package com.day.demo.controller;

import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import com.day.demo.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author leewebi-n
 */
@RestController
public class ApiCtroller {

    Logger log = LoggerFactory.getLogger(ApiCtroller.class);

    @Autowired
    private ApiService apiService;

    @PostMapping("/ApiKey")
    //ResultDTO<LoginDTO>
    public ResultDTO<LoginDTO> ApiTest(@RequestBody LoginDTO loginDTO){
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        resultDTO = apiService.ApiRequest(loginDTO);

        return  resultDTO;
    }
}
