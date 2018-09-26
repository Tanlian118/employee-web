package com.employee.request;

import com.tan.kit.constant.StatusCode;
import com.tan.kit.param.BaseQueryParam;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-15 22:10
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserListParam extends BaseQueryParam {

    /**
     * 姓名
     */
    String username;

    /**
     * 用户id
     */
    String uid;

    /**
     * 手机号码
     */
    String phone;

    /**
     * 状态：-1/0/1 -> 删除/禁用/正常
     */
    StatusCode status;

}
