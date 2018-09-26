package com.employee.back.service.impl;

import com.employee.back.dao.UserDAO;
import com.employee.back.service.UserService;
import com.employee.back.transformers.UserTransformers;
import com.employee.dto.UserDTO;
import com.employee.entity.UserEntity;
import com.employee.param.UserQueryParam;
import com.tan.kit.constant.StateCode;
import com.tan.kit.converter.BaseTransformer;
import com.tan.kit.dto.PageModel;
import com.tan.kit.dto.ResultDTO;
import com.tan.kit.guava2.Lists2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-16 12:04
 **/
@Slf4j
@Service("employeeService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO employeeDAO;

    @Override
    public ResultDTO<Void> addOrUpdateUser(UserDTO employeeDTO) {
        UserEntity employeeEntity = BaseTransformer.convert(employeeDTO, new UserEntity());
            employeeDAO.add(employeeEntity);
            return ResultDTO.successfy();
    }

    @Override
    public ResultDTO<Void> updateById(Set<Integer> employeeUserIds) {
        if (CollectionUtils.isEmpty(employeeUserIds)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "employeeUserId is empty");
        }
        employeeDAO.updateById(employeeUserIds);
        return ResultDTO.successfy();
    }

    @Override
    public PageModel<UserDTO> queryByParam(UserQueryParam queryParam) {
        log.info("员工查询参数：{}",queryParam);
        if (queryParam == null) {
            return PageModel.emptyModel();
        }
        List<UserEntity> employeeEntities = employeeDAO.query(queryParam);
        List<UserDTO> employeeDTOs = Lists2.transform(employeeEntities, UserTransformers.ENTITY_TO_DTO);
        int count = employeeDAO.count(queryParam);
        return PageModel.build(employeeDTOs, count);

    }
}
