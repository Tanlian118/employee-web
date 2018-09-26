package com.employee.back.dao;

import com.employee.entity.EmployeeOrderProductEntity;
import com.employee.param.EmployeeOrderProductParam;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Tanlian
 * @create 2018-09-23 19:08
 **/
public interface EmployeeOrderProductDAO {

    @Select({"<script>",
            "SELECT  product_num, product_name, product_subtitle, product_image, product_price, weight",
            "FROM employee_order_product",
            "WHERE status = 1",
            "<if test='orderNos != null and orderNos.size() > 0 '>",
            "<foreach item='orderNo' collection='orderNos' open='AND order_no IN(' separator=',' close=')'>",
                "#{orderNo}",
            "</foreach>",
            "</if>",
            "</script>"
    })
    List<EmployeeOrderProductEntity> queryByparam(EmployeeOrderProductParam  queryParam);
}
