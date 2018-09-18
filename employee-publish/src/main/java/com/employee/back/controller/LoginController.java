package com.employee.back.controller;

import com.employee.back.service.EmployeeService;
import com.employee.common.constant.StateCode;
import com.employee.common.dto.ResultDTO;
import com.employee.dto.EmployeeDTO;
import com.employee.param.EmployeeQueryParam;
import com.employee.vo.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Tanlian
 * @create 2018-09-17 23:24
 **/
@RestController
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<EmployeeVO> login(@RequestParam String username, @RequestParam String password) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请输入用户名和密码");
        }
        EmployeeQueryParam employeeQueryParam = new EmployeeQueryParam();
        employeeQueryParam.setUsername(username);
        List<EmployeeDTO> employeeDTOs = employeeService.queryByParam(employeeQueryParam).getData();


        if (CollectionUtils.isEmpty(employeeDTOs)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "用户不存在");
        }
        return ResultDTO.successfy();
    }

}
