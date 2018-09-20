package com.employee.entity;

import com.tan.kit.constant.StatusCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author Tanlian
 * @create 2018-09-15 22:14
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeProductEntity {

    /**
     * 员工商品id
     */
    Integer employeeProductId;

    /**
     * 商品id
     */
    String productId;

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

    /**
     * 状态：-1/0/1 -> 删除/禁用/正常
     */
    StatusCode status;

    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 更新时间
     */
    Date updateTime;
}
