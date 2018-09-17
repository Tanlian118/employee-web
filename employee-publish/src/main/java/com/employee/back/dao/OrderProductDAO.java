package com.employee.back.dao;

import com.employee.entity.OrderProductEntity;
import com.employee.param.OrderProductQueryParam;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 22:24
 **/

public interface OrderProductDAO {

    @Select({"<script>",
            "SELECT product_code, product_name, product_subtitle, product_image, product_price",
            "weight, update_time",
            "FROM employee_order_product",
            "WHERE status=1 AND",
            "<if test='productIds!= null and productIds.size() >0'>",
            "<foreach item='id' collection='productIds' open='AND product_id IN(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</if>",
            "<if test='productCode!= null'>",
            "AND product_code LIKE CONCAT('%',#{productCode},'%')",
            "</if>",
            "<if test='productName!=null'>",
            "AND product_name LIKE CONCAT('%',#{productName},'%')",
            "</if>",
            "ORDER BY weight DESC",
            "<if test='needPagination == true'>",
            "LIMIT #{page},#{pageSize}",
            "</if>",
            "</script>"})
    List<OrderProductEntity> queryByParam(OrderProductQueryParam queryParam);

    @Update({"<script>",
            "UPDATE employee_order_product SET status= 0",
            "WHERE order_product_id IN",
            "<foreach item='id' collection='ids' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"})
    int delete(Set<Integer> employeeProductIds);
}
