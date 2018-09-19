package com.employee.back.service;

import com.employee.dto.EmployeeProductDTO;
import com.employee.param.EmployeeProductQueryParam;
import com.tan.kit.dto.PageModel;
import com.tan.kit.dto.ResultDTO;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 13:51
 **/

public interface EmployeeProductService {


    ResultDTO<Void> save(List<EmployeeProductDTO> employeeProductDTOs);


    ResultDTO<Void> delete(Set<Integer> employeeProductIds);


    PageModel<EmployeeProductDTO> queryByParam(EmployeeProductQueryParam queryParam);
}
