package com.employee.back.service;

import com.employee.common.dto.ResultDTO;
import com.employee.dto.ProductDTO;
import com.employee.param.ProductQueryParam;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 14:36
 **/
public interface OrderProductService {


    List<ProductDTO> queryByParam(ProductQueryParam queryParam);

    ResultDTO<Void> delete(Set<Integer> employeeProductIds);
}
