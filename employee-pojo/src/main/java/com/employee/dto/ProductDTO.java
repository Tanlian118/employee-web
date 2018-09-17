package com.employee.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Tanlian
 * @create 2018-09-17 20:51
 **/
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {

    /**
     * 商品id
     */
    Integer productId;

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

    /**
     * 状态:0:未上架；1:已上架；2:已下架
     */
    Integer status;

    /**
     * 商品类型 (0：一般产品；1：开业礼包；2：优惠礼包；3：秒杀产品；
     * 4：拼团产品；5：限购产品；6：海外购单品；
     * 7：海外购组合；8：换购产品；9：满赠产品；10：减重训练营产品；
     * 11：减重训练营产品）
     */
    Integer type;

    /**
     * 商品标签(0：普通商品；1：新人专享)
     */
    Integer tag;
}
