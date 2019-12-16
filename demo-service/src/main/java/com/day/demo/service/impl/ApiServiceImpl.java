package com.day.demo.service.impl;

import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import com.day.demo.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {

    Logger log = LoggerFactory.getLogger(ApiService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResultDTO<LoginDTO> ApiRequest(LoginDTO loginDTO) {
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        String ApiKey = "http://localhost:8002/listAll";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("Accept-Charset","utf-8");

//        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<String, Object>();
//        可以直接拼接
//        封装到HttpEntity<ResultDTO<LoginDTO>>(requestJson,headers)里面requestJson可以替换成multiValueMap

        LoginDTO dto = loginDTO;

        try{
            //传参
            HttpEntity<LoginDTO> entity = new HttpEntity<LoginDTO>(dto,headers);
            log.info("》》》》》》》》》》----"+entity);
            //返回值
            ResponseEntity<ResultDTO> responseEntity = restTemplate.exchange(ApiKey, HttpMethod.POST,entity,ResultDTO.class);
            //获取属性
            resultDTO.setResultList(responseEntity.getBody().resultList);
            resultDTO.setResultCode(responseEntity.getBody().getResultCode());
            log.info("Api查询数据："+resultDTO);
        }catch (Exception e){
            log.error("restTemplate.exchange 接口调用异常"+e.getMessage());
        }

        return  resultDTO;
    }
}
