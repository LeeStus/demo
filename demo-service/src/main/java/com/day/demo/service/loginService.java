package com.day.demo.service;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.day.demo.common.exception.CustomizeException;
import com.day.demo.object.LoginDTO;
import com.day.demo.object.ResultDTO;

public interface loginService {

    /**
     * fetch data by rule id
     *
     * @param ruleId rule id
     * @param page page number
     * @param jsonContext json format context
     * @return Result<XxxxDO>
     */
    public ResultDTO<LoginDTO> queryLogin(LoginDTO LoginDTO);

    public ResultDTO<LoginDTO> listALl();

    /**
     * fetch data by rule id
     *
     * @param ruleId rule id
     * @param page page number
     * @param jsonContext json format context
     * @return Result<XxxxDO>
     */
    public ResultDTO<LoginDTO> insertLogin(LoginDTO loginDTO) throws CustomizeException;
}
