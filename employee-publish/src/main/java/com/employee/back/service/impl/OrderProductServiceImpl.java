package com.employee.back.service.impl;

import com.employee.back.dao.OrderProductDAO;
import com.employee.back.service.OrderProductService;
import com.employee.back.transformers.OrderProductTransformers;
import com.employee.common.dto.ResultDTO;
import com.employee.common.guava2.Lists2;
import com.employee.dto.OrderProductDTO;
import com.employee.entity.OrderProductEntity;
import com.employee.param.OrderProductQueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 15:48
 **/
@Service("orderProductService")
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductDAO orderProductDAO;


    @Override
    public List<OrderProductDTO> queryByParam(OrderProductQueryParam queryParam) {
        List<OrderProductEntity> orderProductEntities = orderProductDAO.queryByParam(queryParam);
       return Lists2.transform(orderProductEntities, OrderProductTransformers.ENTITY_TO_DTO);
    }

    @Override
    public ResultDTO<Void> delete(Set<Integer> employeeProductIds) {
        orderProductDAO.delete(employeeProductIds);
        return ResultDTO.successfy();
    }
}
