package com.employee.vo;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-23 12:45
 **/
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeOrderVO {


    /**
     * 订单编号
     */
    String orderNo;

    /**
     * 姓名
     */
    String username;

    /**
     * 手机号码
     */
    String phone;

    /**
     * 快递邮费
     */
    Integer postage;

    /**
     * 商品价格
     */
    Integer productPrice;

    /**
     * 实收金额
     */
    Integer actualAmount;

    /**
     * 支付时间
     */
    Integer payTime;

    /**
     * 快递状态：20-未发货 21- 审核中 22-配货中 23-运输中 24-派送中 25-已签收 26-已拒收 27-已确认收货
     */
    Integer expressStatus;

    /**
     * 快递单号
     */
    String expressNo;


}
