package com.employee.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-16 11:21
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {
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

}
