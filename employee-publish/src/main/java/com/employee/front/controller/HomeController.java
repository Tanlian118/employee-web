package com.employee.front.controller;

import com.employee.dto.EmployeeProductDTO;
import com.employee.front.adapter.HomeAdapter;
import com.tan.kit.dto.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tanlian
 * @create 2018-09-21 20:59
 **/
@RestController
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    private HomeAdapter homeAdapter;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageModel<EmployeeProductDTO> list( ) {
        return homeAdapter.employeeProductList();
    }
}
