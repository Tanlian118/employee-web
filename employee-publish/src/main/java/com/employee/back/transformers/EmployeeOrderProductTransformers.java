package com.employee.back.transformers;

import com.employee.dto.EmployeeOrderProductDTO;
import com.employee.entity.EmployeeOrderProductEntity;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.converter.SafeFunction;

/**
 * @author Tanlian
 * @create 2018-09-23 21:47
 **/

public class EmployeeOrderProductTransformers extends BaseTransformer{

    public static final SafeFunction<EmployeeOrderProductDTO, EmployeeOrderProductEntity> DTO_TO_ENTITY = input -> convert(input, new EmployeeOrderProductEntity());

    public static final SafeFunction<EmployeeOrderProductEntity, EmployeeOrderProductDTO> ENTITY_TO_DTO = input -> convert(input, new EmployeeOrderProductDTO());

}
