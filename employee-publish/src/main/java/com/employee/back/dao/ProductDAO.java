package com.employee.back.dao;

import com.employee.entity.ProductEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 21:13
 **/
public interface ProductDAO {

    @Select({"<script>",
            "SELECT product_id, name, keyword, code, type, tag, status",
            "FROM product",
            "WHERE product_id IN ",
            "<foreach id='id' collection='ids' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"})
    List<ProductEntity> queryByIds(@Param("ids") Set<Integer> productIds);
}
