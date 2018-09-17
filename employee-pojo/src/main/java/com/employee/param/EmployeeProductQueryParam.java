package com.employee.param;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-15 22:14
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeProductQueryParam extends BaseQueryParam {

    /**
     * sku编码
     */
    String productCode;

    /**
     * 商品名称
     */
    String productName;
}
