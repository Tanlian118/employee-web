package com.employee.back.controller;

import com.employee.back.adapter.EmployeeProductAdapter;
import com.employee.request.EmployeeProductListParam;
import com.employee.request.ProductAddRequest;
import com.employee.request.ProductListParam;
import com.employee.vo.ProductVO;
import com.tan.kit.dto.PageModel;
import com.tan.kit.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-16 19:13
 **/
@RestController
@RequestMapping("/em/product/")
public class EmployeeProductController {

    @Autowired
    private EmployeeProductAdapter employeeProductAdapter;

    /**
     * 添加商品
     */
    @RequestMapping(value = "saveProduct", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> saveProduct(@RequestBody ProductAddRequest productAddRequest) {
        return employeeProductAdapter.saveOrUpate(productAddRequest);
    }

    /**
     * 删除商品
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@RequestBody Set<Integer> employeeProductIds) {
        return employeeProductAdapter.delete(employeeProductIds);
    }

    /**
     * 查询商品
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageModel<ProductVO> list(ProductListParam listParam) {
        return employeeProductAdapter.listProduct(listParam);
    }

    /**
     * 商品列表
     */
    @RequestMapping(value = "employeelist", method = RequestMethod.GET)
    public PageModel<ProductVO> productList(EmployeeProductListParam listParam) {
        return employeeProductAdapter.listEmployeeProduct(listParam);
    }



}
