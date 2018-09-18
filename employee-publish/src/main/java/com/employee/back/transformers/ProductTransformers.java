package com.employee.back.transformers;

import com.employee.common.converter.BaseTransformer;
import com.employee.common.converter.SafeFunction;
import com.employee.dto.EmployeeProductDTO;
import com.employee.dto.ExitProductDTO;
import com.employee.entity.ExitProductEntity;

/**
 * @author Tanlian
 * @create 2018-09-17 21:20
 **/
public class ProductTransformers extends BaseTransformer {

    public static final SafeFunction<ExitProductEntity, ExitProductDTO> ENTITY_TO_DTO = input -> convert(input, new ExitProductDTO());

    public static final SafeFunction<ExitProductDTO, EmployeeProductDTO> DTO_TO_DTO = input -> convert(input, new EmployeeProductDTO());

}
