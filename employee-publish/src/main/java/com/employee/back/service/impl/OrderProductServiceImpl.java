package com.employee.back.service.impl;

import com.employee.back.dao.ProductDAO;
import com.employee.back.service.OrderProductService;
import com.employee.back.transformers.OrderProductTransformers;
import com.employee.common.dto.ResultDTO;
import com.employee.common.guava2.Lists2;
import com.employee.dto.ProductDTO;
import com.employee.entity.ProductEntity;
import com.employee.param.ProductQueryParam;
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
    private ProductDAO orderProductDAO;


    @Override
    public List<ProductDTO> queryByParam(ProductQueryParam queryParam) {
        List<ProductEntity> orderProductEntities = orderProductDAO.queryByParam(queryParam);
       return Lists2.transform(orderProductEntities, OrderProductTransformers.ENTITY_TO_DTO);
    }

    @Override
    public ResultDTO<Void> delete(Set<Integer> employeeProductIds) {
        orderProductDAO.delete(employeeProductIds);
        return ResultDTO.successfy();
    }
}
