package com.day.demo.object;

import lombok.Data;

import java.util.List;

/**
 * @author leewebi-n
 */

@Data
public class ResultDTO<T> {
    private String resultCode;
    private String resultMessage;
    public List<T> resultList;
}
