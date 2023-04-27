package com.kiwa.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 商品
 * @author hp
 * @TableName commodity
 */
@TableName(value ="commodity")
public class Commodity extends BaseDomain implements Serializable {
    /**
     * 
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 购买渠道，存渠道id
     */
    @TableField(value = "purchase_way")
    private Integer purchaseWay;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}