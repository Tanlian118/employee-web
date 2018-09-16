package com.employee.vo;

import com.employee.common.constant.StatusCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author Tanlian
 * @create 2018-09-15 23:13
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeVO {

    /**
     * 姓名
     */
    String username;

    /**
     * 手机号码
     */
    String phone;

    /**
     * 状态：-1/0/1 -> 删除/禁用/正常
     */
    StatusCode status;

    /**
     * 更新时间
     */
    Date updateTime;
}
