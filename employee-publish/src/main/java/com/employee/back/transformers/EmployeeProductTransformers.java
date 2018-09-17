package com.employee.back.transformers;

import com.employee.common.converter.BaseTransformer;
import com.employee.common.converter.SafeFunction;
import com.employee.dto.EmployeeProductDTO;
import com.employee.entity.EmployeeProductEntity;
import com.employee.vo.EmployeeProductVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-16 16:00
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeProductTransformers extends BaseTransformer{

   public static  final SafeFunction<EmployeeProductEntity,EmployeeProductDTO> ENTITY_TO_DTO = input -> convert(input, new EmployeeProductDTO());

   public static  final SafeFunction<EmployeeProductDTO,EmployeeProductEntity> DTO_TO_ENTITY = input -> convert(input, new EmployeeProductEntity());

   public static  final SafeFunction<EmployeeProductDTO,EmployeeProductVO> DTO_TO_VO = input -> convert(input, new EmployeeProductVO());
}
