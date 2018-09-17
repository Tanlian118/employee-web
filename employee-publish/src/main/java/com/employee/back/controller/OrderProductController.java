package com.employee.back.controller;

import com.employee.back.adapter.OrderProductAdapter;
import com.employee.common.dto.ResultDTO;
import com.employee.request.OrderProductListParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 19:13
 **/
@RestController
@RequestMapping("/order/")
public class OrderProductController {

    @Autowired
    private OrderProductAdapter orderProductAdapter;

    /**
     * 查询商品列表
     * @param listParam
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResultDTO<Void> list(OrderProductListParam listParam) {
        return orderProductAdapter.listOrderProduct(listParam);
    }

    /**
     * 删除商品
     * @param employeeProductIds
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@RequestBody Set<Integer> employeeProductIds) {
        return orderProductAdapter.delete(employeeProductIds);
    }
}
