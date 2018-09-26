package com.employee.filling;

import com.employee.param.EmployeeProductQueryParam;
import com.employee.param.UserQueryParam;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-23 15:10
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeOrderfillingParam {

    /**
     * 填充用户信息
     */
    UserQueryParam employeeQueryParam;

    /**
     * 填充商品 信息
     */
    EmployeeProductQueryParam employeeProductQueryParam;

    public boolean needEmployeeDTO() {
        return employeeQueryParam != null;
    }

    public boolean needEmployeeProductDTO() {
        return employeeQueryParam != null;
    }
}
