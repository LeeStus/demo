package com.day.demo.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.day.demo.common.Constant;
import com.day.demo.common.exception.CustomizeException;
import com.day.demo.object.ApiDTO;
import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import com.day.demo.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    Logger log = LoggerFactory.getLogger(ApiService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResultDTO<LoginDTO> ApiRequest(LoginDTO loginDTO) {
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        String ApiKey = "http://10.187.60.206:8002/ApiKey";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("Accept-Charset","utf-8");

//        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<String, Object>();
//        可以直接拼接
//        封装到HttpEntity<ResultDTO<LoginDTO>>(requestJson,headers)里面requestJson可以替换成multiValueMap

        LoginDTO dto = loginDTO;

        try {
            //传参
            HttpEntity<LoginDTO> entity = new HttpEntity<LoginDTO>(dto, headers);
            log.info("》》》》》》》》》》----" + entity);
            //返回值
            ResponseEntity<ResultDTO> responseEntity = restTemplate.exchange(ApiKey, HttpMethod.POST, entity, ResultDTO.class);
            //获取属性
            resultDTO.setResultList(responseEntity.getBody().resultList);
            resultDTO.setResultCode(responseEntity.getBody().getResultCode());
            log.info("Api查询数据：" + resultDTO);
        } catch (Exception e) {
            log.error("restTemplate.exchange 接口调用异常" + e.getMessage());
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<String> happinessLimit(ApiDTO apiDTO) throws CustomizeException {
        ResultDTO<String> resultDTO = new ResultDTO<String>();

        String getUrl = "http://*******8/happinesslimit";
        String employeeName = apiDTO.getEmployeeName();
        String employeeTelPhone = apiDTO.getEmployeeTelPhone();
        String employeeBiNo = apiDTO.getEmployeeBipNo();

        //判断拼接条件
        if (null != employeeName) {
            getUrl += "?employee_name=" + employeeName;
        }

//        if(null != employeeTelPhone){
//
//            if(null != employeeName){
//                getUrl += "&employee_telphone=" + employeeTelPhone;
//            }else {
//                getUrl += "?employee_telphone=" + employeeTelPhone;
//            }
//        }

        if (null != employeeBiNo) {
            if (null != employeeName) {
                getUrl += "&employee_bipno=" + employeeBiNo;
            } else {
                getUrl += "?employee_bipno=" + employeeBiNo;
            }
        }
        log.info("url格式:" + getUrl);

        //apikey授权
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("apikey", "");

        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        try {
            ResponseEntity<Object> responseEntity = restTemplate.exchange(getUrl, HttpMethod.GET, httpEntity, Object.class);

            Object resultBody = responseEntity.getBody();

            log.info("接口调用成功,状态码:" + responseEntity.getStatusCode() + ",数据:" + resultBody);

            boolean bool = 200 == responseEntity.getStatusCodeValue();

            if (bool) {
                List resultList = Arrays.asList(resultBody);
                resultDTO.setResultCode(Constant.SUCCESS);
                resultDTO.setResultList(resultList);
            }

        } catch (Exception e) {
            log.error("接口调用异常:" + e.getMessage());
            throw new CustomizeException("获取不到该员工的额度信息。");
        }
        return resultDTO;
    }
}

