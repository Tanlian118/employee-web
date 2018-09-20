package com.employee.back.transformers;

import com.employee.dto.EmployeeProductDTO;
import com.employee.entity.EmployeeProductEntity;
import com.employee.request.ProductAddRequest;
import com.employee.vo.EmployeeProductVO;
import com.employee.vo.ProductVO;
import com.product.dto.ProductDTO;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.converter.SafeFunction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-16 16:00
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeProductTransformers extends BaseTransformer {

   public static final SafeFunction<EmployeeProductEntity, EmployeeProductDTO> ENTITY_TO_DTO = input -> convert(input, new EmployeeProductDTO());

   public static final SafeFunction<EmployeeProductDTO, EmployeeProductEntity> DTO_TO_ENTITY = input -> convert(input, new EmployeeProductEntity());

   public static final SafeFunction<EmployeeProductDTO, EmployeeProductVO> DTO_TO_VO = input -> convert(input, new EmployeeProductVO());
   public static final SafeFunction<EmployeeProductDTO, ProductVO> DTO_TO_PRODUCT_VO = input -> convert(input, new ProductVO());

   public static final SafeFunction<ProductDTO, EmployeeProductDTO> DTO_TO_PRODUCT_DTO = input -> {

      EmployeeProductDTO productDTO = new EmployeeProductDTO();
      productDTO.setProductId(input.getProductId());
      productDTO.setProductCode(input.getCode());
      productDTO.setProductName(input.getName());
      productDTO.setProductSubtitle(input.getKeyword());
      productDTO.setProductImage(input.getHeadImage());
      return productDTO;
   };

   public static final SafeFunction<ProductDTO, ProductVO> PRODUCT_DTO_TO_VO = input -> {
      ProductVO productVO = new ProductVO();
      productVO.setProductCode(input.getCode());
      productVO.setProductName(input.getName());
      productVO.setProductSubtitle(input.getKeyword());
      productVO.setProductImage(input.getHeadImage());
      return productVO;
   };

   public static final SafeFunction<ProductAddRequest, EmployeeProductDTO> REQUEST_TO_DTO = input -> convert(input, new EmployeeProductDTO());
}
