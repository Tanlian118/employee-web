package com.employee.back.controller;

import com.employee.back.adapter.EmployeeOrderAdapter;
import com.employee.request.EmployeeOrderListParam;
import com.employee.vo.EmployeeOrderVO;
import com.employee.vo.OrderDetailVO;
import com.tan.kit.dto.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tanlian
 * @create 2018-09-23 12:43
 **/
@RestController
@RequestMapping("/em/order")
public class EmployeeOrderController {

    @Autowired
    private EmployeeOrderAdapter employeeOrderAdapter;

    /**
     * 查询订单列表
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
  public PageModel<EmployeeOrderVO> listOrder(EmployeeOrderListParam orderListParam) {
        return employeeOrderAdapter.listOrder(orderListParam);
    }

    /**
     * 订单详情
     */
    @RequestMapping(value = "orderDetails", method = RequestMethod.GET)
   public OrderDetailVO listOrderDetail(EmployeeOrderListParam orderListParam) {
        return employeeOrderAdapter.listOrderDetail(orderListParam);
    }
}
