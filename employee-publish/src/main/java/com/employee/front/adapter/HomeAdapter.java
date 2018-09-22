package com.employee.front.adapter;

import com.employee.back.service.EmployeeProductService;
import com.employee.dto.EmployeeProductDTO;
import com.employee.param.EmployeeProductQueryParam;
import com.tan.kit.dto.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Tanlian
 * @create 2018-09-21 21:07
 **/
@Service("homeAdapter")
public class HomeAdapter {

    @Autowired
    private EmployeeProductService employeeProductService;

    public PageModel<EmployeeProductDTO> employeeProductList() {
        EmployeeProductQueryParam queryParam = new EmployeeProductQueryParam();
        PageModel<EmployeeProductDTO> pageModel = employeeProductService.queryByParam(queryParam);
        List<EmployeeProductDTO> employeeProductDTOs = pageModel.getData();
        if (CollectionUtils.isEmpty(employeeProductDTOs)) {
            return PageModel.emptyModel();
        }
        return PageModel.build(employeeProductDTOs, pageModel.getTotalCount());
    }

}
