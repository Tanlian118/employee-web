package com.employee.dto;

import com.tan.kit.constant.StatusCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author Tanlian
 * @create 2018-09-15 23:10
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {


    /**
     * 员工id
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

    /**
     * 密钥
     */
    String publicKey;

    /**
     * 状态：-1/0/1 -> 删除/禁用/正常
     */
    StatusCode status;

    /**
     * 更新时间
     */
    Date updateTime;
}
