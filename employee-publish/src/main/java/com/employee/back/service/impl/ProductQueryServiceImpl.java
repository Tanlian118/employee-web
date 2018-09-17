package com.employee.back.service.impl;

import com.employee.back.dao.ProductDAO;
import com.employee.back.service.ProductQueryService;
import com.employee.back.transformers.ProductTransformers;
import com.employee.common.guava2.Lists2;
import com.employee.dto.ProductDTO;
import com.employee.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 21:12
 **/
@Service("productQueryService")
public class ProductQueryServiceImpl implements ProductQueryService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<ProductDTO> queryProductByIds(Set<Integer> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return Collections.EMPTY_LIST;
        }
        List<ProductEntity> productEntities = productDAO.queryByIds(productIds);
        return Lists2.transform(productEntities, ProductTransformers.ENTITY_TO_DTO);
    }
}
