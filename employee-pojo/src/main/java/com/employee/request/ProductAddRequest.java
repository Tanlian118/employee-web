package com.employee.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-16 0:35
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductAddRequest {


    /**
     * 商品id
     */
    Set<Integer> ProductIds;
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
     *商品权重
     */
    Integer weight;
}
