package com.employee.request;

import com.tan.kit.param.BaseQueryParam;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-23 17:29
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeOrderListParam extends BaseQueryParam{

    /**
     * 订单编号
     */
    Set<String> orderNos;

    /**
     * 用户id
     */
    Set<String> uids;

    /**
     * 姓名
     */
    Set<String> usernames;

    /**
     * 手机号
     */
    Set<String> phones;
}
