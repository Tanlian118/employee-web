package com.employee.request;

import com.tan.kit.param.BaseQueryParam;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-15 22:50
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductListParam extends BaseQueryParam {


    /**
     * 商品id
     */
    Set<String> ProductIds;

    /**
     * sku编码
     */
    String productCode;

    /**
     * 商品名称
     */
    String productName;
}
