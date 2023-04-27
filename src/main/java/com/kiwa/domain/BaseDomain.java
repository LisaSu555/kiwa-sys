package com.kiwa.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author
 */
@Data
public class BaseDomain {
    private Integer createBy;
    private Date createDate;
    private Date updateDate;
    private String deleteFlag;
}
