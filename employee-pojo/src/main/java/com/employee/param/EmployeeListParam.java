package com.employee.param;

import com.employee.common.constant.StatusCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-15 22:10
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeListParam extends BaseQueryParam {

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

}
