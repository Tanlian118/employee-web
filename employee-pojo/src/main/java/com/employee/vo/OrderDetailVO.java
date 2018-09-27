package com.employee.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author Tanlian
 * @create 2018-09-27 23:16
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailVO {

    /**
     * 用户信息
     */
    List<UserVO> userVOs;

    /**
     * 订单详情
     */
    List<EmployeeOrderVO> employeeOrderVOs;

    /**
     * 商品信息
     */
    List<ProductVO> productVOs;

}
