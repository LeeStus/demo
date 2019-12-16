package com.day.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.day.demo.common.Constant;
import com.day.demo.common.exception.CustomizeException;
import com.day.demo.dao.LoginMapper;
import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;
import com.day.demo.service.loginService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leewebi-n
 * Invalid bound statement (not found): com.day.demo.dao.LoginDAO.queryLogin 数据返回的格式不一致
 */
@Service
public class LoginServiceImpl implements loginService {

    Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    //构造器注入
  /*  private final loginDAO dao;

    @Autowired
    public LoginServiceImpl(loginDAO dao) {
        this.dao = dao;
    }*/

  //set注入
   /*public loginDAO dao;

    @Autowired
    public void setDao(loginDAO dao) {
        this.dao = dao;
    }*/

   @Autowired
   private LoginMapper dao;

    @Override
    public ResultDTO<LoginDTO> selectList(LoginDTO loginDTO) {
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        QueryWrapper<LoginDTO> queryWrapper = new QueryWrapper<LoginDTO>();
        queryWrapper.lambda().eq(LoginDTO::getUserName,loginDTO.getUserName()).and(queryWrapper1 -> queryWrapper1.eq(LoginDTO::getUserPassword,loginDTO.getUserPassword()));

        try{
            List<LoginDTO> resultDTOs = dao.selectList(queryWrapper);
            resultDTO.setResultList(resultDTOs);
            resultDTO.setResultCode(Constant.SUCCESS);
        }catch (Exception e) {
            resultDTO.setResultCode(Constant.FAILURE);
            resultDTO.setResultMessage("没有查询结果。");
            log.error("没有查询结果。",e);
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<LoginDTO> listALl() {
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        try{
            List<LoginDTO> resultDTOs = dao.listAll();
            resultDTO.setResultList(resultDTOs);
            resultDTO.setResultCode(Constant.SUCCESS);
        }catch (Exception e) {
            resultDTO.setResultCode(Constant.FAILURE);
            resultDTO.setResultMessage("没有查询结果。");
            log.error("没有查询结果。",e);
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<LoginDTO> insertLogin(LoginDTO loginDTO) throws CustomizeException {
        ResultDTO<LoginDTO> resultDTO = new ResultDTO<LoginDTO>();

        try {
            dao.insert(loginDTO);

            resultDTO.setResultCode(Constant.SUCCESS);
        }catch (Exception e){
            log.error("添加失败",e);
            throw new CustomizeException("添加失败");
        }

        return resultDTO;
    }
}
