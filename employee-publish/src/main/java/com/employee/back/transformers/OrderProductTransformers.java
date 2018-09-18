package com.employee.back.transformers;

import com.employee.common.converter.BaseTransformer;
import com.employee.common.converter.SafeFunction;
import com.employee.dto.ProductDTO;
import com.employee.entity.ProductEntity;
import com.employee.vo.OrderProductVO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-16 16:00
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderProductTransformers extends BaseTransformer{

   public static  final SafeFunction<ProductEntity,ProductDTO> ENTITY_TO_DTO = input -> convert(input, new ProductDTO());

   public static  final SafeFunction<ProductDTO,ProductEntity> DTO_TO_ENTITY = input -> convert(input, new ProductEntity());

   public static  final SafeFunction<ProductDTO,OrderProductVO> DTO_TO_VO = input -> convert(input, new OrderProductVO());
}
