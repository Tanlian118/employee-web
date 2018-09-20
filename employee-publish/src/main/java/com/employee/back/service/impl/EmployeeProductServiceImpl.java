package com.employee.back.service.impl;

import com.employee.back.dao.EmployeeProductDAO;
import com.employee.back.service.EmployeeProductService;
import com.employee.back.transformers.EmployeeProductTransformers;
import com.employee.dto.EmployeeProductDTO;
import com.employee.entity.EmployeeProductEntity;
import com.employee.param.EmployeeProductQueryParam;
import com.google.common.collect.Lists;
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
import java.util.stream.Collectors;

/**
 * @author Tanlian
 * @create 2018-09-17 14:00
 **/
@Slf4j
@Service("employeeProductService")
public class EmployeeProductServiceImpl implements EmployeeProductService {

    @Autowired
    private EmployeeProductDAO employeeProductDAO;

    @Override
    public ResultDTO<Void> saveOrUpdate(List<EmployeeProductDTO> proudctDTOs) {
        List<EmployeeProductEntity> productEntities = Lists2.transform(proudctDTOs, EmployeeProductTransformers.DTO_TO_ENTITY);
        Set<Integer> employeeProductIds = productEntities.stream().map(EmployeeProductEntity::getEmployeeProductId).collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(employeeProductIds)) {
            int affectedRows = employeeProductDAO.save(productEntities);
            log.info("添加商品:{}", affectedRows);
        }
        EmployeeProductEntity employeeProductEntity = productEntities.get(0);
//        EmployeeProductEntity productEntity = productEntities.iterator().next();
        employeeProductDAO.update(employeeProductEntity);
        return ResultDTO.successfy();
    }

    @Override
    public ResultDTO<Void> delete(Set<Integer> employeeProductIds) {
        if (CollectionUtils.isEmpty(employeeProductIds)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "employeeProductIds is empty");
        }
        int affectedRows = employeeProductDAO.delete(employeeProductIds);
        log.info("删除商品:{}", affectedRows);
        return ResultDTO.successfy();
    }

    @Override
    public PageModel<EmployeeProductDTO> queryByParam(EmployeeProductQueryParam queryParam) {
        if (queryParam == null) {
            return PageModel.emptyModel();
        }
        List<EmployeeProductEntity> productEntities = employeeProductDAO.query(queryParam);
        List<EmployeeProductDTO> productDTOs = Lists.newArrayList();
        for (EmployeeProductEntity productEntity : productEntities) {
            EmployeeProductDTO productDTO = BaseTransformer.convert(productEntity, new EmployeeProductDTO());
            productDTOs.add(productDTO);
        }
        int count = employeeProductDAO.count(queryParam);
        return PageModel.build(productDTOs, count);
    }
}
