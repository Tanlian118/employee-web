package com.employee.back.service.impl;

import com.employee.back.dao.EmployeeDAO;
import com.employee.back.service.EmployeeService;
import com.employee.back.transformers.EmployeeTransformers;
import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;
import com.employee.param.EmployeeQueryParam;
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
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public ResultDTO<Void> addOrUpdateUser(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = BaseTransformer.convert(employeeDTO, new EmployeeEntity());
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
    public PageModel<EmployeeDTO> queryByParam(EmployeeQueryParam queryParam) {
        log.info("员工查询参数：{}",queryParam);
        if (queryParam == null) {
            return PageModel.emptyModel();
        }
        List<EmployeeEntity> employeeEntities = employeeDAO.query(queryParam);
        List<EmployeeDTO> employeeDTOs = Lists2.transform(employeeEntities, EmployeeTransformers.ENTITY_TO_DTO);
        int count = employeeDAO.count(queryParam);
        return PageModel.build(employeeDTOs, count);

    }
}
