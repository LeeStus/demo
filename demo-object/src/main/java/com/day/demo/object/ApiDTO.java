package com.day.demo.object;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author leewebi-n
 * 手机号或者BIP必填一个
 */
public class ApiDTO {
    /**
     * 员工名称(employee_name)
     */
    private String employeeName;

    /**
     * 员工手机号(employee_telphone)
     */
    private String employeeTelPhone;

    /**
     * 员工BIP号(employee_bipno)
     */
    private String employeeBipNo;

    /**
     * 幸福度(usable_limit)
     */
    private String usableLimit;

    public String getUsableLimit() {
        return usableLimit;
    }

    public void setUsableLimit(String usableLimit) {
        this.usableLimit = usableLimit;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeTelPhone() {
        return employeeTelPhone;
    }

    public void setEmployeeTelPhone(String employeeTelPhone) {
        this.employeeTelPhone = employeeTelPhone;
    }

    public String getEmployeeBipNo() {
        return employeeBipNo;
    }

    public void setEmployeeBipNo(String employeeBipNo) {
        this.employeeBipNo = employeeBipNo;
    }

    public void setUrlParam(){
        if(null != employeeName){

        }
    }
}
