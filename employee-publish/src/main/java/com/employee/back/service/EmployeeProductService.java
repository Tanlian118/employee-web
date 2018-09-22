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


    /**
     * 添加或修改商品
     * @param employeeProductDTOs
     * @return
     */
    ResultDTO<Void> saveOrUpdate(List<EmployeeProductDTO> employeeProductDTOs);


    /**
     * 删除商品
     * @param employeeProductIds
     * @return
     */
    ResultDTO<Void> delete(Set<Integer> employeeProductIds);

    /**
     * 查询商品
     * @param queryParam
     * @return
     */
    PageModel<EmployeeProductDTO> queryByParam(EmployeeProductQueryParam queryParam);
}
