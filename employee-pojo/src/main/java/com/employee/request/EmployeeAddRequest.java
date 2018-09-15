package com.employee.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-15 22:07
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeAddRequest {

    /**
     * 姓名
     */
    String username;

    /**
     * 手机号码
     */
    String phone;

}
