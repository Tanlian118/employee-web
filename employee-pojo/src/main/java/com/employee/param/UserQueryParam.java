package com.employee.param;

import com.tan.kit.constant.StatusCode;
import com.tan.kit.param.BaseQueryParam;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-15 22:10
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserQueryParam extends BaseQueryParam {

    /**
     * 姓名
     */
    String username;

    /**
     * 用户id
     */
    Set<String> uids;

    /**
     * 手机号码
     */
    String phone;

    /**
     * 状态：-1/0/1 -> 删除/禁用/正常
     */
    StatusCode status;

    /**
     * 创建时间
     */
    Date createTime;
}

