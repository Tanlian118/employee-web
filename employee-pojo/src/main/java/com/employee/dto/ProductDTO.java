package com.employee.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author Tanlian
 * @create 2018-09-15 22:50
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {

    /**
     * sku编码
     */
    String productCode;

    /**
     * 商品名称
     */
    String productName;

    /**
     * 副标题
     */
    String productSubtitle;

    /**
     * 商品主图
     */
    String productImage;

    /**
     * 权重
     */
    Integer weight;

    /**
     * 更新时间
     */
    Date updateTime;

}
