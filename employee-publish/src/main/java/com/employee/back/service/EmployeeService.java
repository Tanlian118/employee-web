package com.employee.back.service;

import com.employee.common.dto.PageModel;
import com.employee.common.dto.ResultDTO;
import com.employee.dto.EmployeeDTO;
import com.employee.param.EmployeeQueryParam;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-16 11:57
 **/
public interface EmployeeService {


    /**
     * 新增用户
     * @param employeeDTO
     * @return
     */
    ResultDTO<Void> addOrUpdateUser(EmployeeDTO employeeDTO);

    /**
     * 禁用用户
     * @param employeeUserIds
     * @return
     */
    ResultDTO<Void> updateById(Set<Integer> employeeUserIds);

    /**
     * 查询用户列表
     * @param
     */
    PageModel<EmployeeDTO> queryByParam(EmployeeQueryParam queryParam);
}
