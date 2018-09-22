package com.employee.front.adapter;

import com.employee.back.service.EmployeeProductService;
import com.employee.dto.EmployeeProductDTO;
import com.employee.param.EmployeeProductQueryParam;
import com.product.dto.ProductStockDTO;
import com.product.service.ProductStockService;
import com.tan.kit.dto.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Tanlian
 * @create 2018-09-21 21:07
 **/
@Service("homeAdapter")
public class HomeAdapter {

    @Autowired
    private ProductStockService productStockService;
    @Autowired
    private EmployeeProductService employeeProductService;

    public List<EmployeeProductDTO> employeeProductList(Set<String> productIds) {
        EmployeeProductQueryParam queryParam = new EmployeeProductQueryParam();
        queryParam.setProductIds(productIds);
        PageModel<EmployeeProductDTO> pageModel = employeeProductService.queryByParam(queryParam);
        List<EmployeeProductDTO> productDTOs = pageModel.getData();
        if (CollectionUtils.isEmpty(productDTOs)) {
            return Collections.emptyList();
        }
        fillProductStockInfo(productDTOs);
        return productDTOs;
    }

    private void fillProductStockInfo(List<EmployeeProductDTO> productDTOs) {
        if (CollectionUtils.isEmpty(productDTOs)) {
            return;
        }
        Set<String> productIds = productDTOs.stream()
                .map(EmployeeProductDTO::getProductId)
                .collect(Collectors.toSet());
        List<ProductStockDTO> productStockDTOs = productStockService.queryByProductIds(productIds);
        Map<String, Integer> productIdAndStockCountMap = productStockDTOs.stream()
                .collect(Collectors.toMap(ProductStockDTO::getProductId, ProductStockDTO::getStockCount));
        productDTOs.forEach(v->v.setStockCount(productIdAndStockCountMap.get(v.getProductId())));
    }
}
