package com.employee.back.controller;

import com.employee.back.service.UserService;
import com.employee.common.util.AESUtil;
import com.employee.common.util.SessionUtil;
import com.employee.dto.UserDTO;
import com.employee.param.UserQueryParam;
import com.employee.vo.UserVO;
import com.tan.kit.constant.StateCode;
import com.tan.kit.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登录controller
 * @author Tanlian
 * @create 2018-09-17 23:24
 **/
@RestController
@RequestMapping("/login/")
public class LoginController {

    @Autowired
    private UserService employeeService;

    /**
     * 登录
     */
    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<UserVO> login(@RequestParam String username, @RequestParam String password,
                                   HttpServletRequest request, HttpServletResponse response) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请输入用户名和密码");
        }
        UserQueryParam userQueryParam = new UserQueryParam();
        userQueryParam.setUsername(username);
        List<UserDTO> employeeDTOs = employeeService.queryByParam(userQueryParam).getData();
        if (CollectionUtils.isEmpty(employeeDTOs)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "用户不存在");
        }
        UserDTO employeeDTO = employeeDTOs.get(0);
        String passwordFromDB = employeeDTO.getPassword();
        String publickey = employeeDTO.getPublicKey();
        String encryPassword = AESUtil.encrypt(password, publickey);
        if (!encryPassword.equals(passwordFromDB)) {

            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "密码错误");
        }
        //TODO 使用redis缓存错误次数
        String employeeUserId = employeeDTO.getUid();
        SessionUtil.addCookie(request, response, employeeUserId);
        return ResultDTO.successfy();
    }

    /**
     * 登出
     */
    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<UserVO> logout(HttpServletRequest request, HttpServletResponse response) {
        SessionUtil.deleteCookie(request, response);
        return ResultDTO.successfy();
    }


}
