package com.employee.back.service;

import com.employee.dto.EmployeeOrderProductDTO;
import com.employee.param.EmployeeOrderProductParam;

import java.util.List;

/**
 * @author Tanlian
 * @create 2018-09-23 21:42
 **/
public interface EmployeeOrderProductService {

    List<EmployeeOrderProductDTO> queryByParm(EmployeeOrderProductParam queryParam);
}
