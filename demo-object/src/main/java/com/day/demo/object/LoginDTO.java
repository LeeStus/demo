package com.day.demo.object;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author leewebi-n
 */
@Data
@TableName("demo_user_t")
public class LoginDTO {
    private String id;
    private String userName;
    private String userPassword;
    private String createUser;
    private Date createDate;
    private String lastUpdateUser;
    private Date lastUpdateDate;
}
