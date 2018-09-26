package com.employee.param;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-23 21:26
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeOrderProductParam {

    /**
     * 商品订单id
     */
    Integer orderProductId;

    /**
     * 订单编号
     */
    Set<String> orderNos;

    /**
     * 商品编码
     */
    String productCode;
}
