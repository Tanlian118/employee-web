package com.employee.back.service;

import com.employee.dto.ExitProductDTO;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 20:50
 **/
public interface ProductQueryService {

    /**
     * 查询商品信息
     * @param productIds
     * @return
     */
    List<ExitProductDTO> queryProductByIds(Set<Integer> productIds);
}
