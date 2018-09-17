package com.employee.back.transformers;

import com.employee.common.converter.BaseTransformer;
import com.employee.common.converter.SafeFunction;
import com.employee.dto.OrderProductDTO;
import com.employee.entity.OrderProductEntity;
import com.employee.vo.OrderProductVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-16 16:00
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderProductTransformers extends BaseTransformer{

   public static  final SafeFunction<OrderProductEntity,OrderProductDTO> ENTITY_TO_DTO = input -> convert(input, new OrderProductDTO());

   public static  final SafeFunction<OrderProductDTO,OrderProductEntity> DTO_TO_ENTITY = input -> convert(input, new OrderProductEntity());

   public static  final SafeFunction<OrderProductDTO,OrderProductVO> DTO_TO_VO = input -> convert(input, new OrderProductVO());
}
