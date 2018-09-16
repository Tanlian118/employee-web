package com.employee.param;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-16 15:17
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseQueryParam {

    /**
     * 当前页数
     */
    int page;

    /**
     * 分页大小
     */
    Integer pageSize;


    /**
     * 是否需要分页
     */
    boolean needPagination;


}
