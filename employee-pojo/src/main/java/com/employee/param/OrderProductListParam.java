package com.employee.param;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-15 22:50
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProductListParam {

    /**
     * sku编码
     */
    String productCode;

    /**
     * 商品名称
     */
    String productName;
}
