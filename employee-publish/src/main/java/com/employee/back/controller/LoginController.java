package com.employee.back.controller;

import com.employee.common.dto.ResultDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tanlian
 * @create 2018-09-17 23:24
 **/
@RestController
@RequestMapping("/login/")
public class LoginController {

    @RequestMapping(value = "login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultDTO login(@RequestParam String name, @RequestParam String phone) {
        return ResultDTO.successfy();
    }

}
