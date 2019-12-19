package com.day.demo.controller;

import com.day.demo.common.Constant;
import com.day.demo.common.exception.CustomizeException;
import com.day.demo.object.ApiDTO;
import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import com.day.demo.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author leewebi-n
 */
@RestController
public class ApiCtroller {

    Logger log = LoggerFactory.getLogger(ApiCtroller.class);

    @Autowired
    private ApiService apiService;

    @PostMapping("/ApiKey")
    public ResultDTO<LoginDTO> ApiTest(@RequestBody LoginDTO loginDTO){
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        resultDTO = apiService.ApiRequest(loginDTO);

        return  resultDTO;
    }

    @PostMapping("/happinessLimit")
    public ResultDTO<String> happinessLimit(@RequestBody ApiDTO apiDTO){
        ResultDTO<String> resultDTO = new ResultDTO<String>();

        try {
            resultDTO = apiService.happinessLimit(apiDTO);
        }catch (CustomizeException e){
            resultDTO.setResultCode(Constant.FAILURE);
            resultDTO.setResultMessage(e.getMessage());
        }

        return  resultDTO;
    }
}
