package com.employee.front.controller;

import com.employee.dto.EmployeeProductDTO;
import com.employee.front.adapter.HomeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-21 20:59
 **/
@RestController
@RequestMapping("/home/")
public class HomeController {

    @Autowired
    private HomeAdapter homeAdapter;

    /**
     * 查询商品列表
     * @param productIds
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<EmployeeProductDTO> list(@RequestParam Set<String> productIds) {
        return homeAdapter.employeeProductList(productIds);
    }
}
