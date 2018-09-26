package com.employee.back.transformers;

import com.employee.dto.UserDTO;
import com.employee.entity.UserEntity;
import com.employee.vo.UserVO;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.converter.SafeFunction;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author Tanlian
 * @create 2018-09-16 16:00
 **/
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserTransformers extends BaseTransformer {

   public static  final SafeFunction<UserEntity,UserDTO> ENTITY_TO_DTO = input -> convert(input, new UserDTO());

   public static  final SafeFunction<UserDTO,UserEntity> DTO_TO_ENTITY = input -> convert(input, new UserEntity());

   public static  final SafeFunction<UserDTO,UserVO> DTO_TO_VO = input -> convert(input, new UserVO());
}
