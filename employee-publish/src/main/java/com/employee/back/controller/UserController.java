package com.employee.back.controller;

import com.employee.back.adapter.UserAdapter;
import com.employee.request.UserAddRequest;
import com.employee.request.UserListParam;
import com.employee.vo.UserVO;
import com.tan.kit.dto.PageModel;
import com.tan.kit.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * 员工列表controller
 * @author Tanlian
 * @create 2018-09-15 22:06
 **/
@Slf4j
@RestController
@RequestMapping("/em/")
public class UserController {

    @Autowired
    private UserAdapter userAdapter;

    /**
     * 添加用户
     */
    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> saveOrEdit(@RequestBody UserAddRequest userAddRequest) {
        return userAdapter.saveOrEditUser(userAddRequest);
    }

    /**
     * 禁用用户
     */
    @RequestMapping(value = "update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO<Void> update(@RequestBody Set<Integer> userIds) {
        return userAdapter.update(userIds);
    }

    /**
     * 查询用户列表
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public PageModel<UserVO> list(UserListParam userListParam) {
        return userAdapter.list(userListParam);
    }

}
