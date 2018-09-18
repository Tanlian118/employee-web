package com.employee.param;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 21:10
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExitProductQueryParam {

    /**
     * 商品id
     */
    Set<Integer> productIds;

    /**
     * 商品名称
     */
    String name;

    /**
     * 副标题
     */
    String keyword;

    /**
     * 编码
     */
    String code;
}
