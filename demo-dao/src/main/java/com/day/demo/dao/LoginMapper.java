package com.day.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.day.demo.object.LoginDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author leewebi-n
 */
@Mapper
public interface LoginMapper extends BaseMapper<LoginDTO>{

    List<LoginDTO> queryLogin(LoginDTO loginDTO);

    List<LoginDTO> listAll();

}