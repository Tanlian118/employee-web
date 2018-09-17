package com.employee.back.service;

import com.employee.common.dto.ResultDTO;
import com.employee.dto.OrderProductDTO;
import com.employee.param.OrderProductQueryParam;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 14:36
 **/
public interface OrderProductService {


    List<OrderProductDTO> queryByParam(OrderProductQueryParam queryParam);

    ResultDTO<Void> delete(Set<Integer> employeeProductIds);
}
