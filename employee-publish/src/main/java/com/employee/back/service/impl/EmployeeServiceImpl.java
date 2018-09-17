package com.employee.back.service.impl;

import com.employee.back.dao.EmployeeDAO;
import com.employee.back.service.EmployeeService;
import com.employee.back.transformers.EmployeeTransformers;
import com.employee.common.constant.StateCode;
import com.employee.common.converter.BaseTransformer;
import com.employee.common.dto.PageModel;
import com.employee.common.dto.ResultDTO;
import com.employee.common.guava2.Lists2;
import com.employee.dto.EmployeeDTO;
import com.employee.entity.EmployeeEntity;
import com.employee.param.EmployeeQueryParam;
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
        if (employeeEntity.getEmployeeUserId() == null) {
            employeeDAO.add(employeeEntity);
            return ResultDTO.successfy();
        }
        employeeDAO.update(employeeEntity);
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
