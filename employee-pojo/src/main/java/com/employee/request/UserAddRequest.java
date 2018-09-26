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
public class UserAddRequest {


    /**
     * 员工Id
     */
    String uid;

    /**
     * 姓名
     */
    String username;

    /**
     * 手机号码
     */
    String phone;

    /**
     * 用户密码
     */
    String password;

}
