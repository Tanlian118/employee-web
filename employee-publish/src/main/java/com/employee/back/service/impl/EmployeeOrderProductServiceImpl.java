package com.employee.back.service.impl;

import com.employee.back.dao.EmployeeOrderProductDAO;
import com.employee.back.service.EmployeeOrderProductService;
import com.employee.back.transformers.EmployeeOrderProductTransformers;
import com.employee.dto.EmployeeOrderProductDTO;
import com.employee.entity.EmployeeOrderProductEntity;
import com.employee.param.EmployeeOrderProductParam;
import com.tan.kit.guava2.Lists2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author Tanlian
 * @create 2018-09-23 19:07
 **/
@Service("employeeOrderProductService")
public class EmployeeOrderProductServiceImpl implements EmployeeOrderProductService {

    @Autowired
    private EmployeeOrderProductDAO employeeOrderProductDAO;

    @Override
    public List<EmployeeOrderProductDTO> queryByParm(EmployeeOrderProductParam queryParam) {
        if (queryParam == null) {
            return Collections.emptyList();
        }
        List<EmployeeOrderProductEntity> orderProductEntities = employeeOrderProductDAO.queryByparam(queryParam);
        if (CollectionUtils.isEmpty(orderProductEntities)) {
            return Collections.emptyList();
        }
     return Lists2.transform(orderProductEntities, EmployeeOrderProductTransformers.ENTITY_TO_DTO);
    }
}
