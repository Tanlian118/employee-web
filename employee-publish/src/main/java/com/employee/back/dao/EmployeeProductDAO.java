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

    @Insert({"INSERT INTO employee_product(employee_product_id, product_id, product_code, product_name,",
            " product_subtitle, product_image)",
            "VALUES(#{entity.employeeProductId}, #{entity.productId},#{entity.productCode},",
            "#{entity.productName}, #{entity.productSubtitle},#{entity.productImage})"})
    int save(@Param("entity") EmployeeProductEntity employeeProductEntity);

    @Update({"UPDATE employee_product",
            "SET product_code=#{entity.productCode}, product_name=#{entity.productName}",
            "product_subtitle=#{entity.productSubtitle}, product_image=#{entity.productImage}",
            "WHERE status = 1"
    })
    int update(@Param("entity") EmployeeProductEntity employeeProductEntity);


    @Update({"<script>",
            "UPDATE employee_product SET status= -1",
            "WHERE employee_product_Id IN",
            "<foreach item='id' collection='ids' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"})
    int delete(@Param("ids") Set<Integer> employeeProductIds);


    @Select({"<script>",
            "SELECT product_id, product_code, product_name,product_subtitle, product_image",
            "FROM employee_product",
            "WHERE status = 1",
            "<if test='productCode!= null'>",
            "AND product_code LIKE CONCAT('%',#{productCode},'%')",
            "</if>",
            "<if test='productName!= null'>",
            "AND product_name LIKE CONCAT('%', #{productName},'%')",
            "</if>",
            "ORDER BY product_code DESC",
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
            "AND product_code LIKE CONCAT('%',#{productCode},'%')",
            "</if>",
            "<if test='productName!= null'>",
            "AND product_name LIKE CONCAT('%', #{productName},'%')",
            "</if>",
            "ORDER BY product_code DESC",
            "</script>"
    })
    int count (EmployeeProductQueryParam queryParam);
}
