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
    Set<String> productIds;

    /**
     * 员工购id
     */
    String employeeProductId;

}
