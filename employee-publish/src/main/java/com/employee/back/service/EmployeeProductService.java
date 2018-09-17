package com.employee.back.service;

import com.employee.common.dto.PageModel;
import com.employee.common.dto.ResultDTO;
import com.employee.dto.EmployeeProductDTO;
import com.employee.dto.ProductDTO;
import com.employee.param.EmployeeProductQueryParam;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 13:51
 **/

public interface EmployeeProductService {


    ResultDTO<Void> save(List<ProductDTO> proudctDTO);


    ResultDTO<Void> delete(Set<Integer> employeeProductIds);


    PageModel<EmployeeProductDTO> queryByParam(EmployeeProductQueryParam queryParam);
}
