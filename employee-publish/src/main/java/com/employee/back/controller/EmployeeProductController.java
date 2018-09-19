package com.employee.back.controller;

import com.employee.back.adapter.EmployeeProductAdapter;
import com.employee.request.EmployeeProductListParam;
import com.employee.request.ProductAddRequest;
import com.employee.request.ProductListParam;
import com.employee.vo.EmployeeProductVO;
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
     * @param productAddRequest
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> save(@RequestBody ProductAddRequest productAddRequest) {
        return employeeProductAdapter.save(productAddRequest);
    }

    /**
     * 删除商品
     * @param employeeProductIds
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> delete(@RequestBody Set<Integer> employeeProductIds) {
        return employeeProductAdapter.delete(employeeProductIds);
    }

    /**
     * 查询商品
     * @param listParam
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageModel<EmployeeProductVO> list(EmployeeProductListParam listParam) {
        return employeeProductAdapter.listEmployeeProduct(listParam);
    }

    /**
     * 商品列表
     * @param listParam
     * @return
     */
    @RequestMapping(value = "employeelist", method = RequestMethod.GET)
    public PageModel<ProductVO> productList(ProductListParam listParam) {
        return employeeProductAdapter.listProduct(listParam);
    }
}
