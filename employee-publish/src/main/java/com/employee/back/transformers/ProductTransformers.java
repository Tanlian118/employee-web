package com.employee.back.transformers;

import com.employee.common.converter.BaseTransformer;
import com.employee.common.converter.SafeFunction;
import com.employee.dto.ProductDTO;
import com.employee.entity.ProductEntity;

/**
 * @author Tanlian
 * @create 2018-09-17 21:20
 **/
public class ProductTransformers extends BaseTransformer {

    public static final SafeFunction<ProductEntity, ProductDTO> ENTITY_TO_DTO = input -> convert(input, new ProductDTO());
}
