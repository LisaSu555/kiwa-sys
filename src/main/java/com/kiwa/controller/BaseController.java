package com.kiwa.controller;

import lombok.Data;

import java.util.Date;

/**
 * 公共的属性和方法
 * @author hp
 */
@Data
public class BaseController {
    private Integer createBy;
    private Date createDate;
    private Date updateDate;
    private String deleteFlag;
}
