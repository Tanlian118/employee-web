package com.employee.back.transformers;

import com.employee.vo.EmployeeOrderVO;
import com.tan.dto.EmployeeOrderDTO;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.converter.SafeFunction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-23 15:52
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeOrderTransformers extends BaseTransformer {

    public static final SafeFunction<EmployeeOrderDTO, EmployeeOrderVO> DTO_TO_VO = input ->convert(input, new EmployeeOrderVO());
}
