package com.day.demo.controller;

import com.day.demo.object.ApiDTO;
import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author leewebi-n
 */
@RestController
public class ApiCtroller {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/ApiKey")
    public ResultDTO<LoginDTO> ApiTest(){
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        String ApiKey = "";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ResultDTO<LoginDTO> requestJson = null;
        HttpEntity<ResultDTO<LoginDTO>> entity = new HttpEntity<ResultDTO<LoginDTO>>(requestJson,headers);
        resultDTO = restTemplate.postForObject(ApiKey, entity, ResultDTO.class);
        System.out.println(resultDTO);
        return  resultDTO;
    }
}
