package com.employee.back.transformers;

import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;
import com.employee.vo.EmployeeVO;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.converter.SafeFunction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-16 16:00
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeTransformers extends BaseTransformer {

   public static  final SafeFunction<EmployeeEntity,EmployeeDTO> ENTITY_TO_DTO = input -> convert(input, new EmployeeDTO());

   public static  final SafeFunction<EmployeeDTO,EmployeeEntity> DTO_TO_ENTITY = input -> convert(input, new EmployeeEntity());

   public static  final SafeFunction<EmployeeDTO,EmployeeVO> DTO_TO_VO = input -> convert(input, new EmployeeVO());
}
