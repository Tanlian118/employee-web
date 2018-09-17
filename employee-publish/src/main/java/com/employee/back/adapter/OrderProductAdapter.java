package com.employee.back.adapter;

import com.employee.back.service.OrderProductService;
import com.employee.common.constant.StateCode;
import com.employee.common.dto.ResultDTO;
import com.employee.request.OrderProductListParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;

/**
 * @author Tanlian
 * @create 2018-09-17 14:35
 **/
@Service("orderProductAdapter")
public class OrderProductAdapter {

    @Autowired
    private OrderProductService orderProductService;


    public ResultDTO<Void> listOrderProduct(OrderProductListParam listParam) {
        return ResultDTO.successfy();
    }

    public ResultDTO<Void> delete(Set<Integer> employeeProductIds) {
        if (CollectionUtils.isEmpty(employeeProductIds)) {
            return ResultDTO.fail(StateCode.ILLEGAL_ARGS, "请选择要删除的商品");
        }
        orderProductService.delete(employeeProductIds);
        return ResultDTO.successfy();
    }
}
