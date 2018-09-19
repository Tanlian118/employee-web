package com.employee.param;

import com.tan.kit.param.BaseQueryParam;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-15 22:14
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeProductQueryParam extends BaseQueryParam {


    /**
     * 商品id
     */
    Set<Integer> productIds;

    /**
     * sku编码
     */
    String productCode;

    /**
     * 商品名称
     */
    String productName;

    /**
     * 是否存在商品
     */
    Boolean exitProductId;
}
