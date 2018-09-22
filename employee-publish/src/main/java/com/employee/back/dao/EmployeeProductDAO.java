package com.employee.back.dao;

import com.employee.entity.EmployeeProductEntity;
import com.employee.param.EmployeeProductQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 15:20
 **/
public interface EmployeeProductDAO {

    @Insert({"<script>",
            "INSERT INTO employee_product",
            "(product_id, product_code, product_name, product_subtitle, product_image)",
            "VALUES",
            "<foreach item='item' collection='entities' separator=','>",
            "(#{item.productId}, #{item.productCode}, #{item.productName},",
            "#{item.productSubtitle}, #{item.productImage})",
            "</foreach>",
            "</script>"})
    int save(@Param("entities") List<EmployeeProductEntity> employeeProductEntities);

    @Update({"UPDATE employee_product",
            "SET product_code=#{productCode}, product_price=#{entity.productPrice}, weight=#{weight}",
            "WHERE status = 1 AND type = 0"
    })
    int update(@Param("entity") EmployeeProductEntity employeeProductEntity);

    @Select({"<script>",
            "SELECT product_id, product_code, product_name,product_subtitle, product_image, product_price, weight",
            "FROM employee_product",
            "WHERE status = 1",
            "<if test='productIds !=null'>",
            "<foreach item='id' collection='productIds' open='AND product_id IN(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</if>",
            "<if test='productCode!= null'>",
            "AND product_code=#{productCode}",
            "</if>",
            "<if test='productName!= null'>",
            "AND product_name LIKE CONCAT('%', #{productName},'%')",
            "</if>",
            "ORDER BY weight DESC",
            "<if test='needPagination == true'>",
            "LIMIT #{page},#{pageSize}",
            "</if>",
            "</script>"
    })
    List<EmployeeProductEntity> query(EmployeeProductQueryParam queryParam);

    @Select({"<script>",
            "SELECT count(1)",
            "FROM employee_product",
            "WHERE status = 1",
            "<if test='productCode!= null'>",
            "AND product_code=#{productCode}",
            "</if>",
            "<if test='productName!= null'>",
            "AND product_name LIKE CONCAT('%', #{productName},'%')",
            "</if>",
            "ORDER BY weight DESC",
            "</script>"
    })
    int count(EmployeeProductQueryParam queryParam);

    @Update({"<script>",
            "UPDATE employee_product SET status= 0",
            "WHERE employee_product_id IN",
            "<foreach item='id' collection='ids' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"})
    int delete(Set<Integer> employeeProductIds);


}
