package com.day.demo.service;

import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApiService {

    public ResultDTO<LoginDTO> ApiRequest(LoginDTO loginDTO);
}
