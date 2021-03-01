package com.day.demo.common.exception;

import lombok.Data;

/**
 * @classname：Exception
 * @description: 自定义异常类
 * @author: leewebi-n
 * @version: 1.0
 * @date: 2019年12月10日 15:55
 */

@Data
public class CustomizeException extends RuntimeException{

    private String msg;
    private int code = 500;

    public CustomizeException(String msg){
        super(msg);
        this.msg = msg;
    }

    public CustomizeException(String msg,Throwable e){
        super(msg,e);
        this.msg = msg;
    }

    public CustomizeException(String msg,int code){
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CustomizeException(String msg,int code,Throwable e){
        super(msg,e);
        this.msg = msg;
        this.code = code;
    }

}
