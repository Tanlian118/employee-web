package com.employee.entity;

import com.employee.common.constant.StatusCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author Tanlian
 * @create 2018-09-15 22:50
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderProductEntity {

    /**
     * 商品订单id
     */
    Integer orderProductId;

    /**
     * 商品Id
     */
    Integer productId;

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
