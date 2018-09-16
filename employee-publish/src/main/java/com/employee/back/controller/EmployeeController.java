package com.employee.back.controller;

import com.employee.back.adapter.EmployeeAdapter;
import com.employee.common.dto.PageModel;
import com.employee.common.dto.ResultDTO;
import com.employee.param.EmployeeListParam;
import com.employee.request.EmployeeAddRequest;
import com.employee.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-15 22:06
 **/
@Slf4j
@RestController
@RequestMapping("/em/")
public class EmployeeController {

    @Autowired
    private EmployeeAdapter employeeAdapter;

    /**
     * 添加用户
     * @param employeeAddRequest
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> saveOrEdit(@RequestBody EmployeeAddRequest employeeAddRequest) {
        return employeeAdapter.saveOrEditUser(employeeAddRequest);
    }

    /**
     * 禁用用户
     * @param employeeUserIds
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> update(@RequestBody Set<Integer> employeeUserIds) {
        return employeeAdapter.update(employeeUserIds);
    }

    /**
     * 查询用户列表
     * @param employeeListParam
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageModel<EmployeeVO> list(EmployeeListParam employeeListParam) {
        return employeeAdapter.list(employeeListParam);
    }

}
