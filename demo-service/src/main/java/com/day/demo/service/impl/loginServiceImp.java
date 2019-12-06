package com.day.demo.service.impl;

import com.day.demo.dao.loginDAO;
import com.day.demo.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImp implements loginService {

    @Autowired
    private loginDAO dao;

    @Override
    public String queryLogin() {

        return null;
    }
}
