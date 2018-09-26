package com.employee.back.controller;

import com.employee.back.adapter.EmployeeOrderAdapter;
import com.employee.request.EmployeeOrderListParam;
import com.employee.vo.EmployeeOrderVO;
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

    @RequestMapping(value = "list", method = RequestMethod.GET)
    PageModel<EmployeeOrderVO> listOrder(EmployeeOrderListParam orderListParam) {
        return employeeOrderAdapter.listOrder(orderListParam);
    }
}
