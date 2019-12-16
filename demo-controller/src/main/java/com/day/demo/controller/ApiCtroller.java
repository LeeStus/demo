package com.day.demo.controller;

import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author leewebi-n
 */
@RestController
public class ApiCtroller {

    Logger log = LoggerFactory.getLogger(ApiCtroller.class);

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/ApiKey")
    //ResultDTO<LoginDTO>
    public ResultDTO<LoginDTO> ApiTest(){
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        String ApiKey = "http://localhost:8002/queryLogin";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResultDTO<LoginDTO> requestJson = new ResultDTO<>();

        try{
            HttpEntity<ResultDTO<LoginDTO>> entity = new HttpEntity<ResultDTO<LoginDTO>>(requestJson,headers);
            ResponseEntity<ResultDTO> responseEntity =restTemplate.exchange(ApiKey, HttpMethod.POST,entity,ResultDTO.class);
            resultDTO.setResultList(responseEntity.getBody().resultList);
            resultDTO.setResultCode(responseEntity.getBody().getResultCode());
            log.info("Api查询数据："+resultDTO);
        }catch (Exception e){
            log.error("restTemplate.exchange 接口调用异常"+e.getMessage());
        }

        return  resultDTO;
    }
}
