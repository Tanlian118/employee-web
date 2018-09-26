package com.employee.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-23 21:42
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeOrderProductDTO {

    /**
     * 商品订单id
     */
    Integer orderProductId;

    /**
     * 商品id
     */
    String productId;

    /**
     * 订单编号
     */
    String orderNo;

    /**
     * 商品编码
     */
    String productCode;

    /**
     * 员工商品id
     */
    Integer employeeProductId;

    /**
     * 商品数量
     */
    Integer productNum;

    /**
     * 商品名称
     */
    String ProductName;

    /**
     * 副标题
     */
    String productSubtitle;

    /**
     * 商品图片
     */
    String ProducImage;

    /**
     * 商品价格
     */
    Integer productPrice;

    /**
     * 权重
     */
    Integer weight;

}
