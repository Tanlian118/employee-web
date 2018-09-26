package com.employee.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-20 0:32
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductVO {


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
     * 商品价格
     */
    Integer productPrice;

    /**
     * 权重
     */
    Integer weight;
}
