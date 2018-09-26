package com.employee.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author Tanlian
 * @create 2018-09-23 18:59
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeOrderProductEntity {

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

    /**
     *状态：-1/0/1 -> 删除/禁用/正常
     */
    Integer status;

    /**
     * 创建时间
     */
    Date createTime;

    /**
     * 更新时间
     */
    Date updateTime;


}
